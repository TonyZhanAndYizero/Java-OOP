package Source;

import java.awt.event.KeyEvent;

public class Utilities {
    public static boolean Keycode_check(char keycode) {
        return Character.isDigit(keycode) || "+-*/.=".indexOf(keycode) != -1;
    }

    public static boolean KeycodeNum_check_std(char keycode) {
        return Character.isDigit(keycode) || keycode == '.';
    }

    public static boolean KeycodeCal_check_std(char keycode) {
        return "+-*/".indexOf(keycode) != -1;
    }

    public static boolean LegalNum_check(String num) {
        return num.matches("-?(0|[1-9]\\d*)(\\.\\d+)?");
    }

    public static int countDot(String num) {
        return num.length() - num.replace(".", "").length();
    }

    public static boolean KeycodeEqual_check(int Keycode) {
        return Keycode == KeyEvent.VK_ENTER || Keycode == KeyEvent.VK_EQUALS;
    }

    public static String stdNum(String Num) {
        if (Num.length() >= 2) {
            if (Num.charAt(Num.length() - 1) == '.') {
                return new String(Num.toCharArray(), 0, Num.length() - 1);
            }
        }
        return Num;
    }
}
