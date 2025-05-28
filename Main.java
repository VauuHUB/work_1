public class Main {
    public static void main(String[] args) {

        //int numThreads = 1;
        //int numThreads = 3;
        int numThreads = 5;

        Threadwork[] workers = new Threadwork[numThreads];

        int[] steps = {1, 2, 3, 4, 5};
        int[] stopDelays = {3000, 5000, 2000, 6000, 4000};

        for (int i = 0; i < numThreads; i++) {
            workers[i] = new Threadwork(i + 1, steps[i]);
            workers[i].start();
        }

        Controller controller = new Controller(workers, stopDelays);
        controller.start();

        for (Threadwork worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

