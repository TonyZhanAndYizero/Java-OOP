package RUNOOB;

public class TestForVars {
    private int instanceVar;//成员变量
    private static int staticVar;//静态变量
    public void method(int parametersVar){//参数变量
        int localVar=10;//局部变量
        instanceVar=localVar;
        staticVar=parametersVar;
        System.out.println("成员变量:"+instanceVar);
        System.out.println("静态变量:"+staticVar);
        System.out.println("参数变量:"+parametersVar);
        System.out.println("局部变量:"+localVar);
    }

    public static void main(String[] args) {
        TestForVars test1=new TestForVars();
        test1.method(20);
    }
}
