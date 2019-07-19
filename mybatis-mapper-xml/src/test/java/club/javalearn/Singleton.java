package club.javalearn;

/**
 * @className: Singleton
 * @description:
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-13 23:51
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int value1;
    public static int value2 = 0;


    private Singleton(){
        value1++;
        value2++;
    }

    public static Singleton getInstance(){
        return singleton;
    }


    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton1 value1:" + singleton.value1);
        System.out.println("Singleton1 value2:" + singleton.value2);

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);
    }
}
class Singleton2{
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){
        value1++;
        value2++;
    }

    public static Singleton2 getInstance2(){
        return singleton2;
    }

}
