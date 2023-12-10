package Source.Calculator;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yury
 * &#064;Description:  scientific calculator's utilities
 * &#064;date  2023/11/22 23:57
 */
public class UtilitiesSci {
    public static boolean checkNum(String num) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }

    public static boolean checkLeftBracketFunction(String ch) {
        return "sctlog!a".contains(ch);
    }

    public static boolean checkPIorE(String ch) {
        return ch.equals("p") || ch.equals("e");
    }

    public static boolean checkPow(String ch) {
        return ch.equals("^");
    }

    public static boolean checkMod(String ch) {
        return ch.equals("m");
    }

    public static boolean checkOperation(String ch) {
        return "+-*/".contains(ch);
    }


    public static String PureNumberWithoutArithmetics(String Num) {
        Pattern pattern = Pattern.compile("-?(0|[1-9]\\d*)(\\.\\d+)?");
        Matcher matcher = pattern.matcher(Num);
        if (matcher.find())
            return matcher.group();
        else
            return "";
    }

    public static boolean checkEqual(KeyEvent e) {
        return e.getKeyChar() == '=' || e.getKeyChar() == KeyEvent.VK_ENTER;
    }
//    public void estimate(){//判断输入是否错误
//        int i = 0;
//        if (str.length() == 0){
//        }
//        if (str.length() == 1){
//            //当只有一位字符时，只能是“0123456789ep”中的一个
//            if ("0123456789ep".indexOf(str.charAt(0)) == -1){
//                jTextField1.setText("输入错误！");
//                indexYN = 1;
//            }
//        }
//        if (str.length() > 1){
//            for (i = 0; i < str.length() - 1; i++) {
//                //1.第一个字符只能为"losctg(0123456789ep"中的一个
//                if ("losctg(0123456789ep".indexOf(str.charAt(0)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //2.“+-*/”后面只能是"0123456789losctg(ep"中的一个
//                if ("+-*/".indexOf(str.charAt(i)) >= 0 && "0123456789losctg(ep".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //3."."后面只能是“0123456789”中的一个
//                if (str.charAt(i) == '.' && "0123456789".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //4."!"后面只能是“+-*/^)”中的一个
//                if (str.charAt(i) == '!' && "+-*/^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //5."losctg"后面只能是“0123456789(ep”中的一个
//                if ("losctg".indexOf(str.charAt(i)) >= 0 && "0123456789(ep".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //6."0"的判断操作
//                if (str.charAt(0) == '0' && str.charAt(1) == '0'){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                if (i >= 1 && str.charAt(i) == '0'){
//                    //&& str.charAt(0) == '0' && str.charAt(1) == '0'
//                    int m = i;
//                    int n = i;
//                    int is = 0;
//                    //1.当0的上一个字符不为"0123456789."时，后一位只能是“+-*/.!^)”中的一个
//                    if ("0123456789.".indexOf(str.charAt(m - 1)) == -1 && "+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("输入错误！");
//                        indexYN = 1;
//                    }
//                    //2.如果0的上一位为“.”,则后一位只能是“0123456789+-*/.^)”中的一个
//                    if (str.charAt(m - 1) == '.' && "0123456789+-*/.^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("输入错误！");
//                        indexYN = 1;
//                    }
//                    n -= 1;
//                    while (n > 0){
//                        if ("(+-*/^glosct".indexOf(str.charAt(n)) >= 0){
//                            break;
//                        }
//                        if (str.charAt(n) == '.'){
//                            is++;
//                        }
//                        n--;
//                    }
//
//                    //3.如果0到上一个运算符之间没有“.”的话，整数位第一个只能是“123456789”，
//                    //  且后一位只能是“0123456789+-*/.!^)”中的一个。
//                    if ((is == 0 && str.charAt(n) == '0') || "0123456789+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("输入错误！");
//                        indexYN = 1;
//                    }
//                    //4.如果0到上一个运算符之间有一个“.”的话,则后一位只能是“0123456789+-*/.^)”中的一个
//                    if (is == 1 && "0123456789+-*/.^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("输入错误！");
//                        indexYN = 1;
//                    }
//                    if (is > 1){
//                        jTextField1.setText("输入错误！");
//                        indexYN = 1;
//                    }
//
//                }
//                //7."123456789"后面只能是“0123456789+-*/.!^)”中的一个
//                if ("123456789".indexOf(str.charAt(i)) >= 0 && "0123456789+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //8."("后面只能是“0123456789locstg()ep”中的一个
//                if (str.charAt(i) == '(' && "0123456789locstg()ep".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //9.")"后面只能是“+-*/!^)”中的一个
//                if (str.charAt(i) == ')' && "+-*/!^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //10.最后一位字符只能是“0123456789!)ep”中的一个
//                if ("0123456789!)ep".indexOf(str.charAt(str.length() - 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//                //12.不能有多个“.”
//                if (i > 2 && str.charAt(i) == '.'){
//                    int n = i - 1;
//                    int is = 0;
//                    while (n > 0){
//                        if ("(+-*/^glosct".indexOf(str.charAt(n)) >= 0){
//                            break;
//                        }
//                        if (str.charAt(n) == '.'){
//                            is++;
//                        }
//                        n--;
//                    }
//                    if (is > 0){
//                        jTextField1.setText("输入错误！");
//                        indexYN = 1;
//                    }
//                }
//                //13."ep"后面只能是“+-*/^)”中的一个
//                if ("ep".indexOf(str.charAt(i)) >= 0 && "+-*/^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("输入错误！");
//                    indexYN = 1;
//                }
//            }
//        }
//    }

}
