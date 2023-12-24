package Source.Tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * BigDecimal calculate
 * @author Mercy
 */
public class FourArithmetic {
    /**
     * Description: Do  calculation by the input expression.
     * @param s1 The fist number.
     * @param item The operator.
     * @param s2 The second number.
     * @return A big decimal of the calculation result.
     */
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
            return null;
        }
        if(res.toPlainString().length()>10000)
            return null;
        return res.stripTrailingZeros();
    }

}
