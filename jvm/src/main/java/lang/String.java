package lang;

/**
 * @author Hank
 * @date 2022-09-01 23:49
 */
public class String {
    static {
        System.out.println("我是自定义String类的静态代码块");
    }

    // 无法执行，双亲委派模型，java.lang.String在引导类加载器中加载，是没有main方法的
    public static void main(String[] args) {
        System.out.println("hello, jvm");
    }
}
