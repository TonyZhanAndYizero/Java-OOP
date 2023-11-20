package Source;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a series of universal function
 *
 * @author TonyZhan
 */
public class Utilities {
    /**
     * to check the possible input.
     *
     * @param keycode a keyboard listener of char.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean Keycode_check(char keycode) {
        return Character.isDigit(keycode) || "+-*/.=".indexOf(keycode) != -1;
    }

    /**
     * to check the possible number input.
     *
     * @param keycode a keyboard listener of char.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean KeycodeNum_check_std(char keycode) {
        return Character.isDigit(keycode) || keycode == '.';
    }

    /**
     * to check the possible arithmetic sign.
     *
     * @param keycode a keyboard listener of char.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean KeycodeCal_check_std(char keycode) {
        return "+-*/".indexOf(keycode) != -1;
    }

    /**
     * to check the number is legal or not.
     *
     * @param num a number String.
     * @return whether it is legal.
     * @author TonyZhan
     */
    public static boolean LegalNum_check(String num) {
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
     * to return a standard num (only circumstance: 0.)
     *
     * @param Num a number String.
     * @return the standard String.
     * @author TonyZhan
     */

//    public static String stdNum(String Num) {
//        if (Num.length() >= 2) {
//            if (Num.charAt(Num.length() - 1) == '.') {
//                return new String(Num.toCharArray(), 0, Num.length() - 1);
//            }
//        }
//        return Num;
//    }
    public static String PureNumberWithoutArithmetics(String Num){
        Pattern pattern = Pattern.compile("-?(0|[1-9]\\d*)(\\.\\d+)?");
        Matcher matcher = pattern.matcher(Num);
        if (matcher.find())
            return matcher.group();
        else
            return "";
    }

    public static String PureArithmetic(String Num){
        Pattern pattern = Pattern.compile("[+\\-*/]");
        Matcher matcher = pattern.matcher(Num);
        if (matcher.find())
            return matcher.group();
        else
            return "";
    }
}
