package Source.Calculator;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a series of universal function
 *
 * @author TonyZhan
 */
public class UtilitiesStd {
    /**
     * to check the possible input.
     *
     * @param keycode a keyboard listener of char.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean keycodeCheck(char keycode) {
        return Character.isDigit(keycode) || "+-*/.=".indexOf(keycode) != -1;
    }

    public static boolean keySpecialCodeCheck(int keycode) {
        return keycode == KeyEvent.VK_ESCAPE || keycode == KeyEvent.VK_DELETE || keycode == KeyEvent.VK_BACK_SPACE || keycode == KeyEvent.VK_ENTER;
    }

    /**
     * to check the possible number input.
     *
     * @param keycode a keyboard listener of char.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean keycodeNumCheckStd(char keycode) {
        return Character.isDigit(keycode) || keycode == '.';
    }

    /**
     * to check the possible arithmetic sign.
     *
     * @param keycode a keyboard listener of char.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean keycodeCalCheckStd(char keycode) {
        return "+-*/".indexOf(keycode) != -1;
    }

    /**
     * to check the number is legal or not.
     *
     * @param num a number String.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean legalNumCheck(String num) {
        return num.matches("-?(0|[1-9]\\d*)(\\.\\d+)?");
    }

    /**
     * to count the dots' amount of the number String.
     *
     * @param num a number String.
     * @return the amount of dots.
     * @author TonyZhan
     */
    public static int countDot(String num) {
        return num.length() - num.replace(".", "").length();
    }

    /**
     * to check whether press the calculate key or not.
     *
     * @param Keycode a keyboard listener of int.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean KeycodeEqual_check(int Keycode) {
        return Keycode == KeyEvent.VK_ENTER || Keycode == KeyEvent.VK_EQUALS;
    }

    /**
     * to return a standard num
     *
     * @param Num a number String.
     * @return the standard String.
     * @author TonyZhan
     */

    public static String PureNumberWithoutArithmetics(String Num) {
        Pattern pattern = Pattern.compile("-?(0|[1-9]\\d*)(\\.\\d+)?([Ee][+-]?\\d+)?");
        Matcher matcher = pattern.matcher(Num);
        if (matcher.find())
            return matcher.group();
        else
            return "";
    }

    /**
     * to return a standard Arithmetic sign
     *
     * @param Num a number String.
     * @return the standard String.
     * @author TonyZhan
     */
    public static String PureArithmetic(String Num) {
        Pattern pattern = Pattern.compile("[+\\-*/]");
        Matcher matcher = pattern.matcher(Num);
        if (matcher.find())
            return matcher.group();
        else
            return "";
    }

    /**
     * to return a standard equal
     *
     * @param Num a number String.
     * @return the standard String.
     * @author TonyZhan
     */
    public static String PureEqual(String Num) {
        Pattern pattern = Pattern.compile("=");
        Matcher matcher = pattern.matcher(Num);
        if (matcher.find())
            return matcher.group();
        else
            return "";
    }
}
