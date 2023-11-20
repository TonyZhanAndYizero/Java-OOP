package Source.Tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * BigDecimal calculate
 * @author Mercy
 */
public class FourArithmetic {
    private static List<String> parseToSuffixExpression(List<String> expressionList) {
        //创建一个栈用于保存操作符
        Stack<String> opStack = new Stack<>();
        //创建一个list用于保存后缀表达式
        List<String> suffixList = new ArrayList<>();
        for (String item : expressionList) {
            //得到数或操作符
            if (isOperator(item)) {
                //是操作符 判断操作符栈是否为空
                if (opStack.isEmpty() || "(".equals(opStack.peek()) || priority(item) > priority(opStack.peek())) {
                    //为空或者栈顶元素为左括号或者当前操作符大于栈顶操作符直接压栈
                    opStack.push(item);
                } else {
                    //否则将栈中元素出栈如队，直到遇到大于当前操作符或者遇到左括号时
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())) {
                        if (priority(item) <= priority(opStack.peek())) {
                            suffixList.add(opStack.pop());
                        } else
                            break;
                    }
                    //当前操作符压栈
                    opStack.push(item);
                }
            } else if (isNumber(item)) {
                //是数字则直接入队
                suffixList.add(item);
            } else if ("(".equals(item)) {
                //是左括号，压栈
                opStack.push(item);
            } else if (")".equals(item)) {
                //是右括号 ，将栈中元素弹出入队，直到遇到左括号，左括号出栈，但不入队
                while (!opStack.isEmpty()) {
                    if ("(".equals(opStack.peek())) {
                        opStack.pop();
                        break;
                    } else {
                        suffixList.add(opStack.pop());
                    }
                }
            } else if (".".equals(item)) {
                //System.out.print('a');
                suffixList.add(item);
            } else {
                System.out.println("有非法字符！请重新输入:");
                return null;
            }
        }
        //循环完毕，如果操作符栈中元素不为空，将栈中元素出栈入队
        while (!opStack.isEmpty()) {
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    //判断字符串是否为操作符
    public static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    //判断是否为整数或者浮点数
    public static boolean isNumber(String num) {
        return num.matches("^([0-9]{1,}[.][0-9]*)$") || num.matches("^([0-9]{1,})$");
    }

    //判断是不是整数
    public static boolean isInteger(Double num) {
        if (num % 1 == 0)
            return true;
        else
            return false;
    }

    //获取操作符的优先级
    public static int priority(String op) {
        if (op.equals("*") || op.equals("/")) {
            return 1;
        } else if (op.equals("+") || op.equals("-")) {
            return 0;
        }
        return -1;
    }


    //为方便操作将表达式转为list
    private static List<String> expressionToList(String expression) {
        int index = 0;
        List<String> list = new ArrayList<>();
        do {
            char ch = expression.charAt(index);
            if (ch != 46 && (ch <= 47 || ch >= 58)) {
                //是操作符，直接添加至list中
                if (ch == '-' && (index - 1 < 0 || !isNumber(expression.charAt(index - 1) + ""))) {
                    index++;
                    list.add("0");
                    list.add(ch + "");
                } else {
                    index++;
                    list.add(ch + "");
                }
            } else {
                //是数字,判断多位数的情况
                String str = "";
                while (index < expression.length() && (expression.charAt(index) > 47 && expression.charAt(index) < 58 || expression.charAt(index) == 46)) {
                    str += expression.charAt(index);
                    index++;
                }
                list.add(str);
                //System.out.println(str);
            }
        } while (index < expression.length());
        return list;
    }

    //根据后缀表达式list计算结果
    private static BigDecimal cal(List<String> list) {
        Stack<BigDecimal> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if (item.matches("^([0-9]{1,}[.][0-9]*)$") || item.matches("^([0-9]{1,})$")) {
                //是数字(整型或者浮点型)
                stack.push(new BigDecimal(item));
            } else {
                try {
                    BigDecimal num2 = stack.pop();
                    //System.out.print(num2);
                    BigDecimal num1 = stack.pop();
                    BigDecimal res = null;
                    if (item.equals("+"))
                        res = num1.add(num2);
                    else if (item.equals("-"))
                        res = num1.subtract(num2);
                    else if (item.equals("*"))
                        res = num1.multiply(num2);
                    else if (item.equals("/")) {
                        try {
                            res = num1.divide(num2);
                        } catch (ArithmeticException a) {
                            try {
                                res = num1.divide(num2, 10, RoundingMode.HALF_UP);
                            } catch (ArithmeticException b) {
                                System.out.println("运算错误！请重新输入：");
                                return null;
                            }
                        }
                    } else {
                        System.out.println("运算符号错误！请重新输入:");
                        return null;
                    }
                    res = res.stripTrailingZeros();
                    stack.push(res);
                } catch (EmptyStackException e) {
                    System.out.println("格式错误！请重新输入:");
                    return null;
                }
                //是操作符，取出栈顶两个元素
            }
        }
        return stack.pop();
    }

    public static BigDecimal calculatePlain(String s1, String item, String s2) {
        BigDecimal num1 = new BigDecimal(s1);
        BigDecimal num2 = new BigDecimal(s2);
        BigDecimal res;
        if (item.equals("+"))
            res = num1.add(num2);
        else if (item.equals("-"))
            res = num1.subtract(num2);
        else if (item.equals("*"))
            res = num1.multiply(num2);
        else if (item.equals("/")) {
            try {
                res = num1.divide(num2);
            } catch (ArithmeticException a) {
                try {
                    res = num1.divide(num2, 10, RoundingMode.HALF_UP);
                } catch (ArithmeticException b) {
                    return null;
                }
            }
        } else {
            System.out.println("运算符号错误！请重新输入:");
            return null;
        }
        return res.stripTrailingZeros();
    }

    public static BigDecimal calculateEngineer(String expression) {
        if (expression.isBlank())
            return null;
        List<String> expressionList = expressionToList(expression.replace(" ", ""));
//        System.out.println("中缀表达式转为list结构="+expressionList);
        //将中缀表达式转换为后缀表达式
        List<String> suffixList = parseToSuffixExpression(expressionList);
        //System.out.println("对应的后缀表达式列表结构="+suffixList);
        //根据后缀表达式计算结果
        if (suffixList != null) {
            BigDecimal calculateResult = cal(suffixList);
            if (calculateResult != null)
                return calculateResult;
        }
        return null;
    }
}
