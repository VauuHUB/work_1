public class Threadwork extends Thread {

    private final int id;
    private final int step;
    private volatile boolean canStop = false;

    private long sum = 0;
    private long count = 0;

    public Threadwork(int id, int step) {
        this.id = id;
        this.step = step;
    }

    public void allowStop() {
        canStop = true;
    }

    @Override
    public void run() {
        int current = 0;
        while (!canStop) {
            sum += current;
            current += step;
            count++;

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread № " + id +
                " | Sum: " + sum +
                " | Elements use: " + count);
    }
}




