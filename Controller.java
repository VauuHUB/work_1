public class Controller extends Thread {
    private final Threadwork[] threads;
    private final int[] delays;

    public Controller(Threadwork[] threads, int[] delays) {
        this.threads = threads;
        this.delays = delays;
    }

    @Override
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(delays[index]);
                    threads[index].allowStop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


