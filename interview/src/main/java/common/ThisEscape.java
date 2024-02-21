package common;

/**
 * @author Hank
 * @date 2024-02-21 21:05
 */
public class ThisEscape {
    private int m = 8;

    public ThisEscape() {
//        System.out.println(m);
        new Thread(() -> System.out.println(m)).start();
    }

    public static void main(String[] args) {
        new ThisEscape();
    }
}
