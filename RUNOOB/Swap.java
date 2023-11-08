package RUNOOB;

public class Swap {
    private int a=10;
    private int b=20;
    public void swap(){
        int temp=a;
        a=b;
        b=temp;
    }
    public static void staticSwap(Swap s){
        int temp=s.a;
        s.a=s.b;
        s.b=temp;
    }

    public static void main(String[] args) {
        Swap s=new Swap();
        s.swap();
        System.out.println("a is "+s.a);
        System.out.println("b is "+s.b);

        staticSwap(s);
        System.out.println("a is "+s.a);
        System.out.println("b is "+s.b);
    }
}
