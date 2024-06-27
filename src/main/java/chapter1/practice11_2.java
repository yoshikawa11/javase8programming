package chapter1;

public class practice11_2 {
    public static void main(String[] args) {
        class MyClass extends S implements I_default {
            // do nothing
        }

        class MyClass2 extends S implements I_default {
            @Override
            public void f() {
                I_default.super.f();
            }
        }

        class MyClass3 extends SAbstract implements  I_default {
            @Override
            public void f() {
                System.out.println("method f override");
            }
        }

        class MyClass4 extends SStatic implements I_static {
            // do nothing
            public void callMethod() {
                SStatic.f();
                I_static.f();
            }
        }

        // 具象メソッド同士ではスーパークラスのメソッドが呼ばれる
        MyClass mc = new MyClass();
        mc.f();

        // I_defaultインターフェースのメソッドが呼ばれる
        MyClass2 mc2 = new MyClass2();
        mc2.f();

        // 抽象メソッドとdefaultメソッドでは抽象メソッドをオーバーライドする
        MyClass3 mc3 = new MyClass3();
        mc3.f();

        // staticメソッド同士は競合しない
        MyClass4 mc4 = new MyClass4();
        mc4.callMethod();

    }

    static class S {
        public void f() {
            System.out.println("method f in supper class");
        }
    }

    abstract static class SAbstract {
        public abstract void f();
    }

    static class SStatic {
        public static void f() {
            System.out.println("method f in static class method");
        }
    }

    interface I_default {
        default void f() {
            System.out.println("method f in default method");
        }
    }

    interface I_static {
        static void f() {
            System.out.println("method f in static method");
        }
    }
}
