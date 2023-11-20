package Source.Tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class FourArithmetic {
    private static List<String> parseToSuffixExpression(List<String> expressionList) {
        //����һ��ջ���ڱ��������
        Stack<String> opStack = new Stack<>();
        //����һ��list���ڱ����׺���ʽ
        List<String> suffixList = new ArrayList<>();
        for(String item : expressionList){
            //�õ����������
            if(isOperator(item)){
                //�ǲ����� �жϲ�����ջ�Ƿ�Ϊ��
                if(opStack.isEmpty() || "(".equals(opStack.peek()) || priority(item) > priority(opStack.peek())){
                    //Ϊ�ջ���ջ��Ԫ��Ϊ�����Ż��ߵ�ǰ����������ջ��������ֱ��ѹջ
                    opStack.push(item);
                }else {
                    //����ջ��Ԫ�س�ջ��ӣ�ֱ���������ڵ�ǰ��������������������ʱ
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())){
                        if(priority(item) <= priority(opStack.peek())){
                            suffixList.add(opStack.pop());
                        }
                        else
                            break;
                    }
                    //��ǰ������ѹջ
                    opStack.push(item);
                }
            }else if(isNumber(item)){
                //��������ֱ�����
                suffixList.add(item);
            }else if("(".equals(item)){
                //�������ţ�ѹջ
                opStack.push(item);
            }else if(")".equals(item)){
                //�������� ����ջ��Ԫ�ص�����ӣ�ֱ�����������ţ������ų�ջ���������
                while (!opStack.isEmpty()){
                    if("(".equals(opStack.peek())){
                        opStack.pop();
                        break;
                    }else {
                        suffixList.add(opStack.pop());
                    }
                }
            }else if(".".equals(item)){
                //System.out.print('a');
                suffixList.add(item);
            }else {
                System.out.println("�зǷ��ַ�������������:");
                return null;
            }
        }
        //ѭ����ϣ����������ջ��Ԫ�ز�Ϊ�գ���ջ��Ԫ�س�ջ���
        while (!opStack.isEmpty()){
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    //�ж��ַ����Ƿ�Ϊ������
    public static boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    //�ж��Ƿ�Ϊ�������߸�����
    public static boolean isNumber(String num){
        return num.matches("^([0-9]{1,}[.][0-9]*)$") || num.matches("^([0-9]{1,})$");
    }
    //�ж��ǲ�������
    public static boolean isInteger(Double num){
        if (num % 1 == 0)
            return true;
        else
            return false;
    }

    //��ȡ�����������ȼ�
    public static int priority(String op){
        if(op.equals("*") || op.equals("/")){
            return 1;
        }else if(op.equals("+") || op.equals("-")){
            return 0;
        }
        return -1;
    }


    //Ϊ������������ʽתΪlist
    private static List<String> expressionToList(String expression) {
        int index = 0;
        List<String> list = new ArrayList<>();
        do{
            char ch = expression.charAt(index);
            if(ch!=46 && (ch <= 47 || ch >= 58)){
                //�ǲ�������ֱ�������list��
                index ++ ;
                list.add(ch+"");
            }else{
                //������,�ж϶�λ�������
                String str = "";
                while (index < expression.length() && (expression.charAt(index) >47 && expression.charAt(index) < 58 || expression.charAt(index)==46)){
                    str += expression.charAt(index);
                    index ++;
                }
                list.add(str);
                //System.out.println(str);
            }
        }while (index < expression.length());
        return list;
    }

    //���ݺ�׺���ʽlist������
    private static BigDecimal calculate(List<String> list) {
        Stack<BigDecimal> stack = new Stack<>();
        for(int i=0; i<list.size(); i++){
            String item = list.get(i);
            if(item.matches("^([0-9]{1,}[.][0-9]*)$") || item.matches("^([0-9]{1,})$")){
                //������(���ͻ��߸�����)
                stack.push(new BigDecimal(item));
            }else {
                try{
                    BigDecimal num2 = stack.pop();
                    //System.out.print(num2);
                    BigDecimal num1 = stack.pop();
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
                                System.out.println("����������������룺");
                                return null;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("������Ŵ�������������:");
                        return null;
                    }
                    stack.push(res);
                }catch (EmptyStackException e)
                {
                    System.out.println("��ʽ��������������:");
                    return null;
                }
                //�ǲ�������ȡ��ջ������Ԫ��
            }
        }
        return stack.pop().stripTrailingZeros();
    }
    public static BigDecimal calculate(String expression)
    {
        if(expression.isBlank())
            return null;
        List<String> expressionList = expressionToList(expression.replace(" ", ""));
        //System.out.println("��׺���ʽתΪlist�ṹ="+expressionList);
        //����׺���ʽת��Ϊ��׺���ʽ
        List<String> suffixList = parseToSuffixExpression(expressionList);
        //System.out.println("��Ӧ�ĺ�׺���ʽ�б�ṹ="+suffixList);
        //���ݺ�׺���ʽ������
        if(suffixList != null)
        {
            BigDecimal calculateResult = calculate(suffixList);
            if(calculateResult != null)
                return calculateResult;
        }
        return null;
    }
}
