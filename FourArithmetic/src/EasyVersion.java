import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class EasyVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String item;
        BigDecimal num1;
        BigDecimal num2;
        while(true)
        {
            System.out.println("请输入第一个数：");
            while(true)
            {
                try
                {
                    str = sc.nextLine();
                    str = str.replaceAll(" ", "");
                    num1 = new BigDecimal(str);
                    break;
                }catch (NumberFormatException e)
                {
                    System.out.println("数字格式错误！请重新输入：");
                }
            }
            System.out.println("请输入运算符号：");
            while(true)
            {
                str = sc.nextLine();
                str = str.replaceAll(" ", "");
                if(str.matches("\\+|-|\\*|/")) {
                    item = str;
                    break;
                }
                else
                    System.out.println("运算符号错误！请重新输入：");
            }
            System.out.println("请输入第二个数：");
            while(true)
            {
                try
                {
                    str = sc.nextLine();
                    str = str.replaceAll(" ", "");
                    num2 = new BigDecimal(str);
                    break;
                }catch (NumberFormatException e)
                {
                    System.out.println("数字格式错误！请重新输入：");
                }
            }
            BigDecimal res = null;
            if(item.equals("+"))
                res = num1.add(num2);
            else if(item.equals("-"))
                res = num1.subtract(num2);
            else if(item.equals("*"))
                res = num1.multiply(num2);
            else if(item.equals("/"))
            {
                try {
                    res = num1.divide(num2);
                }catch (ArithmeticException a)
                {
                    try {
                        res = num1.divide(num2, 10, RoundingMode.HALF_UP);
                    }
                    catch (ArithmeticException b)
                    {
                        System.out.println("运算错误！请重新输入：");
                        continue;
                    }
                }
            }
            System.out.println("= " + res);
        }
    }
}
