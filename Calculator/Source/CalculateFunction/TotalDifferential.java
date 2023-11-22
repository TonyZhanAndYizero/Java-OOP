package Source.CalculateFunction;

import org.apache.poi.hpsf.Array;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;

import java.util.ArrayList;

public class TotalDifferential {
    public static String getTotalDifferential(String expression){
        ArrayList<Character> variables = new ArrayList<>();

        // 创建符号计算引擎
        ExprEvaluator evaluator = new ExprEvaluator();

        // 定义变量
        for(int i = 0; i < expression.length(); i ++){
            char c = expression.charAt(i);
            if(i - 1 >= 0 && expression.charAt(i - 1) == '(' && Character.isLetter(c)){
                evaluator.defineVariable(String.valueOf(c));
                variables.add(c);
            }
        }

        try {
            //IExpr result = evaluator.evaluate("1/0");
            // 尝试解析表达式
            IExpr expr = evaluator.evaluate(expression);
            StringBuilder output = new StringBuilder("d(" + expression + ") = ");
            // 计算偏导数

            for (char variable : variables) {
                //System.out.println(variable);
                IExpr partialDerivative = evaluator.evaluate("D(" + expr + ", " + variable + ")");
                output.append(partialDerivative.toString().toLowerCase()).append("d(").append(variable).append(") + ");
            }

            // 输出结果
            output.delete(output.length() - 3, output.length());
            return output.toString();
        }
        catch (Exception e) {
            System.err.println("fail: " + e.getMessage());
            return "fail";
        }

    }

    public static void main(String[] args) {
        String testFunction = "(x)";
        String testFunction1 = "(x) * (y) * (z)";
        String expression2 = "(a) * ((b) + (c)) / ((d) - (e))";
        String expression5 = "((a) + 2) * 3 - (b)";
        System.out.println(getTotalDifferential(expression5));
        System.out.println(getTotalDifferential(expression2));
        System.out.println(getTotalDifferential(testFunction));
        System.out.println(getTotalDifferential(testFunction1));
    }
}
