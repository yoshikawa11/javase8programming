package chapter1;

public class practice7 {
        public static void main(String[] args) {
            andThen(() -> System.out.println("first-run"),
                    () -> System.out.println("second-run")
            ).run();
        }

        public static Runnable andThen(Runnable first, Runnable second) {
            return () -> {
                first.run();
                second.run();
            };
        }
}
