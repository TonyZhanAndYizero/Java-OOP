package Source;

public class Utilities {
    public static boolean Keycode_check(char keycode){
        return Character.isDigit(keycode) || "+-*/.=".indexOf(keycode) != -1;
    }
    public static boolean Keycode_check_std(char keycode){
        return Character.isDigit(keycode) || keycode=='.';
    }

    public static boolean LegalNum_check(String num){
        return num.matches("-?(0|[1-9]\\d*)(\\.\\d+)?");
    }
    public static int countDot(String num){
        return num.length() - num.replace(".", "").length();
    }
}
