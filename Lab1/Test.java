import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("22373340-ղ�Ѳ�");
        Scanner sc=new Scanner(System.in);
        String msg;
        while(true){
            msg=sc.nextLine();
            if (msg.equals("QUIT")) {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            } else {
                System.out.println("Hello, World!");
            }
        }
    }
}