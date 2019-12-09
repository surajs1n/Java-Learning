package threads;

/**
 * @author - suraj.s
 * @date - 2019-12-09
 */
public class ThreadSynchronizationExampleV2 {

    private static class Counter {
        int a;

        Counter() {
            this.a = 0;
        }

        public synchronized void addNumberV1(final int addition) {
            this.a = this.a + addition;
            System.out.println(String.format("[Thread : %s] has added %d value using addNumberV1()",
                    Thread.currentThread().getName(), addition));
        }

        public void addNumberV2(final int addition) {
            synchronized (this) {
                this.a = this.a + addition;
                System.out.println(String.format("[Thread : %s] has added %d value using addNumberV2()",
                        Thread.currentThread().getName(), addition));
            }
        }

        // This is not thread-safe.
        public void addNumberV3(final int addition) {
            this.a = this.a + addition;
            System.out.println(String.format("[Thread : %s] has added %d value using addNumberV3()",
                    Thread.currentThread().getName(), addition));
        }
    }

    private static class CounterThread extends Thread {
        private Counter counter;

        CounterThread(final Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i=1; i<=10; i++) {
                this.counter.addNumberV3(i);
            }

            for (int i=1; i<=10; i++) {
                this.counter.addNumberV1(i);
            }

            for (int i=1; i<=10; i++) {
                this.counter.addNumberV2(i);
            }
        }
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();

        final CounterThread counterThreadOne = new CounterThread(counter);
        final CounterThread counterThreadTwo = new CounterThread(counter);

        counterThreadOne.start();
        counterThreadTwo.start();
    }
}
