package chapter1;

public class practice6 {
    public static void main(String[] args) {
        new Thread(uncheck(() ->{
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public interface RunnableEx {
        void run() throws Exception;
    }
}
