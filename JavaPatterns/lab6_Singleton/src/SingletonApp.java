
public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 1000;

        Thread t[] = new Thread[SIZE];

        Singleton arr[] = new Singleton[SIZE];
        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i=0; i<SIZE; i++) {
            t[i].join();
        }

        System.out.println(Singleton.counter);
    }
}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

 class Singleton {
     private static Object sync = new Object();

     public static int counter = 0;
     private static volatile Singleton instance = null;

     private Singleton() {
         counter++;
     }

     public static Singleton getInstance() {
         if (instance == null) {
             synchronized(sync) {
                 if (instance == null)
                     instance = new Singleton();
             }
         }
         return instance;
     }
 }