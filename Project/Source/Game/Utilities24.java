package Source.Game;

import java.util.ArrayList;
import java.util.Random;
import Source.Tools.*;
/**
 * Description: Utilities for 24-point game.
 * @author Yury
 */
public class Utilities24 {
    Random random = new Random();
    /**
     * Description: To get a random number from 1 to mod.
     * 
     * @param mod int, modulus
     * @return int      
     * @author Yury
     */
    protected int getRandomNum(int mod) {
        return (random.nextInt() % mod + mod) % mod + 1;
    }
    /**
     * Description: Get a sign of operation through op.
     *
     * @param op int
     * @return java.lang.String
     * @author Yury
     */
    protected String getOp(int op) {
        if (op == 1) return "+";
        else if (op == 2) return "-";
        else if (op == 3) return "\u00D7";
        else return "\u00F7";
    }
    ArrayList<String> ansList = new ArrayList<>();
    /**
     * Description: If the answer equals to 24, add it to the answer list.
     *
     * @param ans String
     * @param model String, the equation
     * @author Yury
     */
    protected void checkAns(String ans, String model) {
        if (ans != null && ans.equals("24")) {
            ansList.add(model);
        }
    }
    /**
     * Description: To check if the equation with a, b, c and d has an answer.
     *
     * @param a int
     * @param b int
     * @param c int
     * @param d int
     * @return boolean
     * @author Yury
     */
    protected boolean checkExistingAnswer(int a, int b, int c, int d) {
        ansList.clear();
        int op1, op2, op3;
        for (op1 = 1; op1 <= 4; op1++) {
            for (op2 = 1; op2 <= 4; op2++)
                for (op3 = 1; op3 <= 4; op3++) {
                    // 对应表达式类型：((A□B)□C)□D
                    String model1 = "((" + a + getOp(op1) + b + ")" + getOp(op2) + c + ")" + getOp(op3) + d;
                    // 对应表达式类型：(A□(B□C))□D
                    String model2 = "(" + a + getOp(op1) + "(" + b + getOp(op2) + c + ")" + ")" + getOp(op3) + d;
                    //对应表达式类型：A□(B□(C□D))
                    String model3 = a + getOp(op1) + "(" + b + getOp(op2) + "(" + c + getOp(op3) + d + "))";
                    // 对应表达式类型：A□((B□C)□D)
                    String model4 = a + getOp(op1) + "((" + b + getOp(op2) + c + ")" + getOp(op3) + d + ")";
                    //对应表达式类型：(A□B)□(C□D)
                    String model5 = "(" + a + getOp(op1) + b + ")" + getOp(op2) + "(" + c + getOp(op3) + d + ")";
                    String ans1 = EngineerArithmetic.engineerCal(model1);
                    String ans2 = EngineerArithmetic.engineerCal(model2);
                    String ans3 = EngineerArithmetic.engineerCal(model3);
                    String ans4 = EngineerArithmetic.engineerCal(model4);
                    String ans5 = EngineerArithmetic.engineerCal(model5);
                    checkAns(ans1, model1);
                    checkAns(ans2, model2);
                    checkAns(ans3, model3);
                    checkAns(ans4, model4);
                    checkAns(ans5, model5);
                }
        }
        return !ansList.isEmpty();
    }
}
