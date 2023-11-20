package Source.CalculateFunction;

import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;

public class TotalDifferential {
    public static void main(String[] args) {
        // 输入的函数表达式（包含非法函数）
        String expression = "sin(x) * coa(y)";

        // 创建符号计算引擎
        ExprEvaluator evaluator = new ExprEvaluator();

        // 定义变量
        evaluator.defineVariable("x");
        evaluator.defineVariable("y");
        try {
            //IExpr result = evaluator.evaluate("1/0");
            // 尝试解析表达式
            IExpr expr = evaluator.evaluate(expression);

            // 计算偏导数
            IExpr partialDerivativeX = evaluator.evaluate("D(" + expr + ", x)");
            IExpr partialDerivativeY = evaluator.evaluate("D(" + expr + ", y)");
            // 输出结果
            String output = "d(" + expression + ") = "
                    + partialDerivativeX.toString().toLowerCase() + "dx + " + partialDerivativeY.toString().toLowerCase() + "dy";
            System.out.println(output);
            /*if (result.isInfinity()) {
                System.out.println("Meet Infinity");
            } else {
                System.out.println("result: " + result);
            }*/
        }
        catch (Exception e) {
            System.err.println("发生异常: " + e.getMessage());
        }
    }
}
