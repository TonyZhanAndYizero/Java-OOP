package Source;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yury
 * &#064;Description:  scientific calculator's utilities
 * &#064;date  2023/11/22 23:57
 */
public class UtilitiesSci {
    /**
     * Description: To check if the input String is a number.
     * 
     * @param num String
     * @return boolean      
     * @author Yury
     */
    public static boolean checkNum(String num) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
    /**
     * Description: To check if the input String stands for a left bracket function.
     *
     * @param ch String
     * @return boolean
     * @author Yury
     */
    public static boolean checkLeftBracketFunction(String ch) {
        return "sctlog!a".contains(ch);
    }
    /**
     * Description: To check if the input is p or e.
     *
     * @param ch String
     * @return boolean
     * @author Yury
     */
    public static boolean checkPIorE(String ch) {
        return ch.equals("p") || ch.equals("e");
    }
    /**
     * Description: To check if the input String is the mark of power.
     *
     * @param ch String
     * @return boolean
     * @author Yury
     */
    public static boolean checkPow(String ch) {
        return ch.equals("^");
    }
    /**
     * Description: To check if the input String is the mark of mod.
     *
     * @param ch String
     * @return boolean
     * @author Yury
     */
    public static boolean checkMod(String ch) {
        return ch.equals("m");
    }
    /**
     * Description: To check if the input String is a kind of sign of operation.
     *
     * @param ch String
     * @return boolean
     * @author Yury
     */
    public static boolean checkOperation(String ch) {
        return "+-*/".contains(ch);
    }
    /**
     * Description: To check the mark of equal.
     *
     * @param e KeyEvent
     * @return boolean
     * @author Yury
     */
    public static boolean checkEqual(KeyEvent e) {
        return e.getKeyChar() == '=' || e.getKeyChar() == KeyEvent.VK_ENTER;
    }

}
