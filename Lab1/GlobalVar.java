public class GlobalVar {
    int a = 10; // ȫ�ֱ���,��ͬ
    double b = 20;
    public static void main(String[] args) {
        GlobalVar globalVar = new GlobalVar();
        System.out.println("ȫ�ֱ��� a = " + globalVar.a);
        // System.out.println("ȫ�ֱ��� a = " +a); ����д��
        globalVar.print();
        System.out.println("ȫ�ֱ����仯�� a = " + globalVar.a);
    }
    public void print() {
        System.out.println("�� print() ��, ȫ�ֱ��� a = " + a + ", b = " + b);
        a = 30;
        System.out.println("�� print() ��, ȫ�ֱ��� a = " + a + ", b = " + b);
    }
}
