package threads;

/**
 * @author - suraj.s
 * @date - 2019-12-11
 */
public class ThreadLocalExample {

    private static class StorageOne {
        private String string;

        StorageOne(final String string) {
            this.string = string;
        }

        public String getString() {
            return this.string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

    private static class StorageTwo {
        private ThreadLocal<String> stringThreadLocal;

        StorageTwo(final ThreadLocal<String> stringThreadLocal) {
            this.stringThreadLocal = stringThreadLocal;
        }

        public String getString() {
            return this.stringThreadLocal.toString();
        }

        public void setStringThreadLocal(ThreadLocal<String> stringThreadLocal) {
            this.stringThreadLocal = stringThreadLocal;
        }
    }

    private static class ThreadExtension extends Thread {
        private StorageOne storageOne;
        private StorageTwo storageTwo;

        ThreadExtension(final StorageOne storageOne, final StorageTwo storageTwo) {
            this.storageOne = storageOne;
            this.storageTwo = storageTwo;
        }

        @Override
        public void run() {
            System.out.println(String.format("[%s] reads StorageOne's value %s",
                    Thread.currentThread().getName(),storageOne.getString()));
            System.out.println(String.format("[%s] reads StorageTwo's value %s",
                    Thread.currentThread().getName(),storageTwo.getString()));

            storageOne.setString("Setting");
        }
    }

    public static void main(String[] args) {
        final StorageOne storageOne = new StorageOne("Value in StorageOne");
        final StorageTwo storageTwo = new StorageTwo(ThreadLocal.withInitial(() -> "Value in StorageTwo"));

        ThreadExtension extensionOne = new ThreadExtension(storageOne, storageTwo);
        ThreadExtension extensionTwo = new ThreadExtension(storageOne, storageTwo);

        extensionOne.start();
        extensionTwo.start();
    }
}
