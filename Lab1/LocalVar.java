public class LocalVar {
    public static void main(String[] args) {
        LocalVar localVar = new LocalVar();
        // System.out.println("�ֲ����� a = " + localVar.a); ���ô�����ͬ
        localVar.print();
        // System.out.println("�仯��ľֲ����� a = " + localVar.a);
    }
    public void print() {
        int a = 10; // �ֲ���������ͬ
        double b = 20;
        System.out.println("�� print() �еľֲ����� a = " + a + ", b = " + b);
        a = 30;
        System.out.println("�� print() �еľֲ����� a = " + a + ", b = " + b);
    }
}