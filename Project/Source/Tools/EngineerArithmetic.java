package Source.Tools;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EngineerArithmetic {
    /**
     * Description: Converts the input expression to an infix form and stores it in a list.
     * @param str The string of input expression.
     * @return An infix expression.
     * @author HeMercy
     */
    public static List<String> infix(String str) {
        int index = 0;
        List<String> list = new ArrayList<>();
        do {
            char ch = str.charAt(index);
            if ("+-*/^!mlogscta()".indexOf(str.charAt(index)) >= 0) {
                if (str.charAt(index) == '-' && (list.isEmpty() || !isNumber(list.get(list.size() - 1)) && !list.get(list.size() - 1).equals(")"))) {
                    list.add("0");
                }
                //是操作符，直接添加至list中
                index++;
                list.add(ch + "");
            } else if (str.charAt(index) == 'e' || str.charAt(index) == 'p') {
                index++;
                list.add(ch + "");
            } else if ("0123456789".indexOf(str.charAt(index)) >= 0) {
                //是数字,判断多位数的情况
                String str1 = "";
                while (index < str.length() && "0123456789.".indexOf(str.charAt(index)) >= 0) {
                    str1 += str.charAt(index);
                    index++;
                }
                list.add(str1);

            }
        } while (index < str.length());
        return list;
    }
    /**
     * Description: Converts the infix list to a suffix list.
     * @param list The list of the infix of input expression.
     * @return A suffix list.
     * @author HeMercy
     */
    public static List<String> suffix(List<String> list) {//中缀表达式转换称后缀表达式
        Stack<String> fuZhan = new Stack<>();
        List<String> list2 = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (isNumber(list.get(i))) {
                    list2.add(list.get(i));
                } else if (list.get(i).charAt(0) == '(') {
                    fuZhan.push(list.get(i));
                } else if (isOperator(list.get(i)) && list.get(i).charAt(0) != '(') {
                    if (fuZhan.isEmpty()) {
                        fuZhan.push(list.get(i));
                    } else {//符栈不为空
                        if (list.get(i).charAt(0) != ')') {
                            if (adv(fuZhan.peek()) < adv(list.get(i))) {
                                //入栈
                                fuZhan.push(list.get(i));
                            } else {//出栈
                                while (!fuZhan.isEmpty() && !"(".equals(fuZhan.peek())) {
                                    if (adv(list.get(i)) <= adv(fuZhan.peek())) {
                                        list2.add(fuZhan.pop());
                                    } else {
                                        fuZhan.push(list.get(i));
                                        break;
                                    }
                                }
                                if (fuZhan.isEmpty() || fuZhan.peek().charAt(0) == '(') {
                                    fuZhan.push(list.get(i));
                                }
                            }
                        } else if (list.get(i).charAt(0) == ')') {
                            while (fuZhan.peek().charAt(0) != '(') {
                                list2.add(fuZhan.pop());
                            }
                            fuZhan.pop();
                        }
                    }
                }
            }
            while (!fuZhan.isEmpty()) {
                list2.add(fuZhan.pop());
            }
        }
        return list2;
    }

    /**
     * Description: Determine whether the string is an operator.
     * @param op The string form of a character in the input expression.
     * @return True if the string is an operator or false if not.
     * @author HeMercy
     */
    public static boolean isOperator(String op) {
        if ("0123456789.ep".indexOf(op.charAt(0)) == -1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Description: Determine whether the string is a number.
     * @param num The string form of a character in the input expression.
     * @return True if the string is a number or false if not.
     * @author HeMercy
     */
    public static boolean isNumber(String num) {//判断是否为操作数
        if ("0123456789ep".indexOf(num.charAt(0)) >= 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Description: Determine the priority of the operator.
     * @param f The string form of an operator in the input expression.
     * @return The priority of the operator.
     * @author HeMercy
     */
    public static int adv(String f) {
        int result = 0;
        switch (f) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            case "m":
                result = 2;
                break;
            case "^":
                result = 3;
                break;
            case "!":
                result = 4;
                break;
            case "g":
                result = 4;
                break;
            case "l":
                result = 4;
                break;
            case "o":
                result = 4;
                break;
            case "s":
                result = 4;
                break;
            case "c":
                result = 4;
                break;
            case "t":
                result = 4;
                break;
            case "a":
                result = 4;
                break;
        }
        return result;
    }

    /**
     * Description: Do the calculation by the suffix list of input expression.
     * @param list2 The suffix list of the input expression.
     * @return A big decimal of the calculation result.
     * @author HeMercy
     */
    public static BigDecimal math(List<String> list2) {//通过后缀表达式进行计算
        Stack<String> stack = new Stack<String>();
        BigDecimal res = null;
        MathContext m1 = new MathContext(514, RoundingMode.HALF_UP);
        MathContext m2 = new MathContext(514, RoundingMode.HALF_UP);
        try {
            for (int i = 0; i < list2.size(); i++) {
                if (isNumber(list2.get(i))) {
                    if (list2.get(i).charAt(0) == 'e') {
                        stack.push(String.valueOf(BigDecimalMath.e(m2)));
                    } else if (list2.get(i).charAt(0) == 'p') {
                        stack.push(String.valueOf(BigDecimalMath.pi(m2)));
                    } else {
                        stack.push(list2.get(i));
                    }
                } else if (isOperator(list2.get(i))) {
                    if (list2.get(i).equals("+")) {
                        BigDecimal num2 = new BigDecimal(stack.pop());
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = num1.add(num2);
                    } else if (list2.get(i).equals("-")) {
                        BigDecimal num2 = new BigDecimal(stack.pop());
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = num1.subtract(num2);
                    } else if (list2.get(i).equals("*")) {
                        BigDecimal num2 = new BigDecimal(stack.pop());
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = num1.multiply(num2);
                    } else if (list2.get(i).equals("/")) {
                        BigDecimal num2 = new BigDecimal(stack.pop());
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        try {
                            res = num1.divide(num2);
                        } catch (ArithmeticException a) {
                            res = num1.divide(num2, 10, RoundingMode.HALF_UP);
                        }
                    } else if (list2.get(i).equals("m")) {
                        BigDecimal num2 = new BigDecimal(stack.pop());
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = num1.remainder(num2, m1);
                    } else if (list2.get(i).equals("^")) {
                        BigDecimal num2 = new BigDecimal(stack.pop());
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.pow(num1, num2, m1);
                    } else if (list2.get(i).equals("!")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.factorial(num1, MathContext.UNLIMITED);
                    } else if (list2.get(i).equals("g")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.sqrt(num1, m1);
                    } else if (list2.get(i).equals("l")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.log(num1, m1);
                    } else if (list2.get(i).equals("o")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.log10(num1, m1);
                    } else if (list2.get(i).equals("s")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.sin(num1, m1);
                    } else if (list2.get(i).equals("c")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.cos(num1, m1);
                    } else if (list2.get(i).equals("t")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = BigDecimalMath.tan(num1, m1);
                    } else if (list2.get(i).equals("a")) {
                        BigDecimal num1 = new BigDecimal(stack.pop());
                        res = num1.abs();
                    }
                    stack.push("" + res.setScale(10, RoundingMode.HALF_UP));
                }
            }
        } catch (ArithmeticException a) {
            System.out.println("运算错误！");
            return null;
        }
        if (!stack.isEmpty())
            return new BigDecimal(stack.pop()).stripTrailingZeros();
        else
            return null;
    }
    /**
     * Description: Convert the input operator to a single character and call math function.
     * @param str The input expression.
     * @return A String of the calculation result.
     * @author HeMercy
     */
    public static String engineerCal(String str) {
        str = str.replaceAll(" ", "");
        List<String> list;
        try {
            str = str.replaceAll("mod", "m");
            str = str.replaceAll("sqrt", "g");
            str = str.replaceAll("log", "o");
            str = str.replaceAll("sin", "s");
            str = str.replaceAll("cos", "c");
            str = str.replaceAll("tan", "t");
            str = str.replaceAll("abs", "a");
            str = str.replaceAll("pi", "p");
            str = str.replaceAll("ln", "l");
            str = str.replaceAll("\u00F7", "/");
            str = str.replaceAll("\u00D7", "*");
            list = infix(str);
            //System.out.println(list);

            list = suffix(list);
            //System.out.println(list);
            return math(list).toPlainString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
