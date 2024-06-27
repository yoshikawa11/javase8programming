package chapter1;

public class practice11 {
    public static void main(String[] args) {
        class AbstractAbstract implements I_abstract, J_abstract {
            @Override
            public void f() {
               System.out.println("override abstract method");
            }
        }

        abstract class AbstractDefault implements I_abstract, J_default {
            public abstract void f();
        }

        class DefaultAbstract implements I_default, J_abstract {
            @Override
            public void f() {
                I_default.super.f();
            }
        }

        class AbstractStatic implements I_abstract, J_static {
            @Override
            public void f() {
                System.out.println("override abstract method");
            }
        }

        class StaticDefault implements I_static, J_default {

        }

        class StaticStatic implements I_static, J_static {
            public void methodCall() {
                I_static.f();
                J_static.f();
            }
        }

        // I,Jがともに抽象メソッドの場合、メソッドの処理を追加する
        AbstractAbstract aa = new AbstractAbstract();
        aa.f();

        AbstractDefault ad = new AbstractDefault() {
            @Override
            public void f() {
                System.out.println("override abstract method");
            }
        };
        ad.f();

        DefaultAbstract da = new DefaultAbstract();
        da.f();

        AbstractStatic as = new AbstractStatic();
        as.f();

        // defaultメソッドが呼ばれる
        StaticDefault sd = new StaticDefault();
        sd.f();

        StaticStatic ss = new StaticStatic();
        ss.methodCall();
    }

    public interface I_abstract {
        void f();
    }

    public interface I_default {
        default void f() {
            System.out.println("interface I: default method");
        }
    }

    public interface I_static {
        static void f() {
            System.out.println("interface I: static method");
        }
    }

    public interface J_abstract {
        void f();
    }

    public interface J_default {
        default void f() {
            System.out.println("interface J: default method");
        }
    }

    public interface J_static {
        static void f() {
            System.out.println("interface J: static method");
        }
    }
}
