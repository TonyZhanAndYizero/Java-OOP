package RUNOOB;

public class TestForVars {
    private int instanceVar;//��Ա����
    private static int staticVar;//��̬����
    public void method(int parametersVar){//��������
        int localVar=10;//�ֲ�����
        instanceVar=localVar;
        staticVar=parametersVar;
        System.out.println("��Ա����:"+instanceVar);
        System.out.println("��̬����:"+staticVar);
        System.out.println("��������:"+parametersVar);
        System.out.println("�ֲ�����:"+localVar);
    }

    public static void main(String[] args) {
        TestForVars test1=new TestForVars();
        test1.method(20);
    }
}
