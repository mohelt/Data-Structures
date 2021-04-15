import java.util.Random;
import java.util.logging.Logger;

public class Timer {
    static Logger log = Logger.getLogger("Timer");

    private static int MIN_REPEATS = 100; // repeat the execution at least this
    private static int MAX_REPEATS = 1000; // repeat the execution at least this

    // number of times
    private static long MIN_SECONDS = (long) (3 * 1e9); // repeat execution of the work
    // until at least this amount of time

    public static double measure(Runnable worker) {
        long n_repeats = 0;
        long start = System.nanoTime();

        while (true) {
            // do work
            //worker();
            worker.run();
            ++n_repeats;

//            if ( (n_repeats > Timer.MIN_REPEATS && // has to run a minimum number of times
//                    n_repeats <= Timer.MAX_REPEATS) &&
//                    (n_repeats % Timer.MIN_REPEATS == 0 && // only check the time every
//                    // min_repeat times because this is expensive
//                    (System.nanoTime() - start) > Timer.MIN_SECONDS) ) {
                if ( n_repeats >= Timer.MAX_REPEATS ||
                        (n_repeats % Timer.MIN_REPEATS == 0 && // only
                        // check the time every
                                // min_repeat times because this is expensive
                                (System.nanoTime() - start) > Timer.MIN_SECONDS))  {
                break;
            }
        }
        long elapsed = System.nanoTime() - start;

//        System.out.println("# elapsed: " + elapsed + ", " + elapsed/1e9 + " -> " +
//                "n_repeats:" +
//                " " + n_repeats);
        return 1e-9 * elapsed / n_repeats;
    }

    public static void main(String[] args) {
        int size = 10000, lowBound=0, highBound = 10000;

        int n_min = 20, n_max = 10000, n_samples = 50;
        // we want to even divide the range on a log scale
        // n_min^{1+alpha*0}, ..., n_min^{1+alpha*i}, ..., n_min^{1 + alpha(n-1)} = n_max
        // alpha = (log(n_max)/log(n_min) - 1) / (n_samples - 1)
        double alpha = ( (Math.log(n_max) / Math.log(n_min)) - 1) / (n_samples-1);
        
        for(int i = 0; i < n_samples; ++i) {
            int n = (int) Math.pow(n_min, (1 + i * alpha));
            Runnable worker = () -> {
                int [] arr = new Random().ints(n).toArray();
            };
            double result = Timer.measure(worker);
//            double result =
//                    Timer.measure(() -> new Random().ints(n, lowBound, highBound).toArray());
            //double result = 0;
            System.out.println(i + "\t" + n + "\t" + result);
        }
    }
}
