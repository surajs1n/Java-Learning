package threads;

import lombok.Data;

/**
 * @author - suraj.s
 * @date - 2019-12-05
 */
public class ThreadsSynchronizationExample {

    @Data
    private static class Sender {
        public void sendMessage(final String message) {
            System.out.println(String.format("[%s] Sending message : %s", Thread.currentThread().getName(), message));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("[%s] Sent message : %s", Thread.currentThread().getName(), message));
        }
    }

    @Data
    private static class SenderThread implements Runnable {
       private Sender sender;
       private String message;


       public SenderThread(final Sender sender, final String message) {
           super();
           this.sender = sender;
           this.message = message;
       }

       @Override
       public void run() {
          synchronized (this.sender) {
              this.sender.sendMessage(this.message);
          }
       }
    }

    public static void main(String[] args) {
        Sender sender = new Sender();

        Thread threadOne = new Thread(new SenderThread(sender, "Message-1"), "Thread-1");
        Thread threadTwo = new Thread(new SenderThread(sender, "Message-2"), "Thread-2");

        threadOne.start();
        threadTwo.start();
    }
}
