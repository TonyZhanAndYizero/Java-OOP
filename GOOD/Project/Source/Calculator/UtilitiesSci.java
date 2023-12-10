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
//    public void estimate(){//�ж������Ƿ����
//        int i = 0;
//        if (str.length() == 0){
//        }
//        if (str.length() == 1){
//            //��ֻ��һλ�ַ�ʱ��ֻ���ǡ�0123456789ep���е�һ��
//            if ("0123456789ep".indexOf(str.charAt(0)) == -1){
//                jTextField1.setText("�������");
//                indexYN = 1;
//            }
//        }
//        if (str.length() > 1){
//            for (i = 0; i < str.length() - 1; i++) {
//                //1.��һ���ַ�ֻ��Ϊ"losctg(0123456789ep"�е�һ��
//                if ("losctg(0123456789ep".indexOf(str.charAt(0)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //2.��+-*/������ֻ����"0123456789losctg(ep"�е�һ��
//                if ("+-*/".indexOf(str.charAt(i)) >= 0 && "0123456789losctg(ep".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //3."."����ֻ���ǡ�0123456789���е�һ��
//                if (str.charAt(i) == '.' && "0123456789".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //4."!"����ֻ���ǡ�+-*/^)���е�һ��
//                if (str.charAt(i) == '!' && "+-*/^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //5."losctg"����ֻ���ǡ�0123456789(ep���е�һ��
//                if ("losctg".indexOf(str.charAt(i)) >= 0 && "0123456789(ep".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //6."0"���жϲ���
//                if (str.charAt(0) == '0' && str.charAt(1) == '0'){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                if (i >= 1 && str.charAt(i) == '0'){
//                    //&& str.charAt(0) == '0' && str.charAt(1) == '0'
//                    int m = i;
//                    int n = i;
//                    int is = 0;
//                    //1.��0����һ���ַ���Ϊ"0123456789."ʱ����һλֻ���ǡ�+-*/.!^)���е�һ��
//                    if ("0123456789.".indexOf(str.charAt(m - 1)) == -1 && "+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("�������");
//                        indexYN = 1;
//                    }
//                    //2.���0����һλΪ��.��,���һλֻ���ǡ�0123456789+-*/.^)���е�һ��
//                    if (str.charAt(m - 1) == '.' && "0123456789+-*/.^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("�������");
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
//                    //3.���0����һ�������֮��û�С�.���Ļ�������λ��һ��ֻ���ǡ�123456789����
//                    //  �Һ�һλֻ���ǡ�0123456789+-*/.!^)���е�һ����
//                    if ((is == 0 && str.charAt(n) == '0') || "0123456789+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("�������");
//                        indexYN = 1;
//                    }
//                    //4.���0����һ�������֮����һ����.���Ļ�,���һλֻ���ǡ�0123456789+-*/.^)���е�һ��
//                    if (is == 1 && "0123456789+-*/.^)".indexOf(str.charAt(i + 1)) == -1){
//                        jTextField1.setText("�������");
//                        indexYN = 1;
//                    }
//                    if (is > 1){
//                        jTextField1.setText("�������");
//                        indexYN = 1;
//                    }
//
//                }
//                //7."123456789"����ֻ���ǡ�0123456789+-*/.!^)���е�һ��
//                if ("123456789".indexOf(str.charAt(i)) >= 0 && "0123456789+-*/.!^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //8."("����ֻ���ǡ�0123456789locstg()ep���е�һ��
//                if (str.charAt(i) == '(' && "0123456789locstg()ep".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //9.")"����ֻ���ǡ�+-*/!^)���е�һ��
//                if (str.charAt(i) == ')' && "+-*/!^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //10.���һλ�ַ�ֻ���ǡ�0123456789!)ep���е�һ��
//                if ("0123456789!)ep".indexOf(str.charAt(str.length() - 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//                //12.�����ж����.��
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
//                        jTextField1.setText("�������");
//                        indexYN = 1;
//                    }
//                }
//                //13."ep"����ֻ���ǡ�+-*/^)���е�һ��
//                if ("ep".indexOf(str.charAt(i)) >= 0 && "+-*/^)".indexOf(str.charAt(i + 1)) == -1){
//                    jTextField1.setText("�������");
//                    indexYN = 1;
//                }
//            }
//        }
//    }

}
