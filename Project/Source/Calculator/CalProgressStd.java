package Source.Calculator;

import Source.Tools.FourArithmetic;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalProgressStd {
    /**
     * to reverse the polar of a number
     *
     * @param e   MouseEvent
     * @param std calculator
     * @author TonyZhan
     */
    public static void polar(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans = new BigDecimal(str_now).negate();
            if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                std.label1.setText("negate" + "(" + str_now + ")" + " = " + ans.toPlainString());
                std.textField1.setText(ans.toPlainString());

                std.newNum = false;
                std.pendingCalToClear = true;
                std.OnceEqual = true;
            } else {
                std.textField1.setText(ans.toPlainString());
            }
        }
    }

    /**
     * to do percentage algorithm
     *
     * @param e   a mouse listener
     * @param std Calculator
     * @author TonyZhan
     */
    public static void percent(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        System.out.println(str_equal);
        // TODO add your code here
        if (e.getButton() == 1) {
            BigDecimal ans = FourArithmetic.calculatePlain(str_now, "*", "0.01");
            if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                if (ans != null) {
                    std.label1.setText(str_now + " " + "*" + " " + "0.01" + " = " + ans.toPlainString());
                    std.textField1.setText(ans.toPlainString());
                }
                std.newNum = false;
                std.pendingCalToClear = true;
                std.OnceEqual = true;
            } else {
                if (ans != null) {
                    std.textField1.setText(ans.toPlainString());
                }
            }
        }
    }

    /**
     * update the textField1 and label1, depending on the input logic
     *
     * @param e   the KeyEvent.
     * @param std Calculator
     * @author TonyZhan
     */

    public static void textFieldAndLabel(KeyEvent e, CalculatorStd std) {
        String str_last = UtilitiesStd.PureNumberWithoutArithmetics(std.label1.getText());
        String str_arithmetic = UtilitiesStd.PureArithmetic(std.label1.getText().replace(str_last, ""));
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        if (!std.error) {
            if (UtilitiesStd.keycodeNumCheckStd(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (std.OnceEqual) {
                    std.label1.setText("");
                    std.textField1.setText("0");
                    InputNumber(std, e);
                    std.OnceEqual = false;
                    std.pendingCalToClear = false;
                } else if (!std.pendingCalToClear)
                    InputNumber(std, e);
                else {
                    std.textField1.setText("");
                    InputNumber(std, e);
                    std.pendingCalToClear = false;
                }
                std.newNum = true;
            } else if ((UtilitiesStd.keycodeCalCheckStd(e.getKeyChar()) && (!std.newNum || str_last.isEmpty()))) {
                std.label1.setText(str_now + " " + e.getKeyChar() + " ");
                std.pendingCalToClear = true;
                std.newNum = false;
                std.OnceEqual = false;
            } else if (UtilitiesStd.keycodeCalCheckStd(e.getKeyChar()) && std.newNum) {
                //TODO yunsuan
                BigDecimal ans = FourArithmetic.calculatePlain(str_last, str_arithmetic, str_now);
                if (ans != null) {
                    std.label1.setText(ans.toPlainString() + " " + e.getKeyChar() + " ");
                    std.textField1.setText(ans.toPlainString());


                } else {
                    std.label1.setText("");
                    std.textField1.setText("ERROR! Press any key to reset.");
                    std.error = true;
                }
                std.newNum = false;
                std.pendingCalToClear = true;
                std.OnceEqual = false;
            } else if (UtilitiesStd.KeycodeEqual_check(e.getKeyCode()) && str_arithmetic.isEmpty()) {
                std.label1.setText(str_now + " = " + str_now);
                std.newNum = false;
                std.pendingCalToClear = true;
                std.OnceEqual = true;
            } else if (UtilitiesStd.KeycodeEqual_check(e.getKeyCode()) && !std.OnceEqual) {
                BigDecimalCal(std, str_last, str_arithmetic, str_now);
                std.OnceEqualConst = str_now;
            } else if (UtilitiesStd.KeycodeEqual_check(e.getKeyCode()) && std.OnceEqual) {
                BigDecimalCal(std, str_now, str_arithmetic, std.OnceEqualConst);
            }
        } else if (UtilitiesStd.keycodeCheck(e.getKeyChar()) || UtilitiesStd.keySpecialCodeCheck(e.getKeyCode())) {
            std.textField1.setText("0");
            std.error = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            std.label1.setText("");
            std.textField1.setText("0");
            std.error = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            std.textField1.setText("0");
            std.error = false;
        }
    }

    /**
     * calculate progress
     *
     * @param std            Calculator
     * @param str_last       a
     * @param str_arithmetic b
     * @param str_now        c, such that a(b)c=...[2(*)3=6]
     * @author TonyZhan
     */
    public static void BigDecimalCal(CalculatorStd std, String str_last, String str_arithmetic, String str_now) {
        BigDecimal ans = FourArithmetic.calculatePlain(str_last, str_arithmetic, str_now);
        if (ans != null) {
            std.label1.setText(str_last + " " + str_arithmetic + " " + str_now + " = " + ans.toPlainString());
            std.textField1.setText(ans.toPlainString());
        } else {
            std.label1.setText("");
            std.textField1.setText("ERROR! Press any key to reset.");
            std.error = true;
        }
        std.newNum = false;
        std.pendingCalToClear = true;
        std.OnceEqual = true;
    }

    /**
     * to input number, maintaining its legitimacy
     *
     * @param std Calculator
     * @param e   a key listener
     * @author TonyZhan
     */
    public static void InputNumber(CalculatorStd std, KeyEvent e) {
        String nowInput = std.textField1.getText();
        if (!nowInput.equals("0")) {
            //无前导0，输入数字
            if (UtilitiesStd.keycodeNumCheckStd(e.getKeyChar()) && UtilitiesStd.countDot(nowInput) < 1) {
                nowInput = nowInput + e.getKeyChar();
            } else if (Character.isDigit(e.getKeyChar())) {
                nowInput = nowInput + e.getKeyChar();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (!nowInput.isEmpty()) {
                    nowInput = nowInput.substring(0, nowInput.length() - 1);
                }
            }
        } else {
            if (Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '0') {
                nowInput = "" + e.getKeyChar();
            } else if (e.getKeyChar() == '.') {
                nowInput = nowInput + ".";
            }
        }
        if (nowInput.isEmpty()) nowInput = "0";
        std.textField1.setText(nowInput);
    }

    /**
     * to calculate 1/x
     *
     * @param e   MouseEvent
     * @param std Calculator
     * @author TonyZhan
     */
    public static void upsideDown(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            if (!std.error) {
                BigDecimal ans = FourArithmetic.calculatePlain("1", "/", str_now);
                if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                    if (ans != null) {
                        std.label1.setText("1" + " " + "/" + " " + str_now + " = " + ans.toPlainString());
                        std.textField1.setText(ans.toPlainString());
                    } else {
                        std.label1.setText("");
                        std.textField1.setText("ERROR! Press any key to reset.");
                        std.error = true;
                        return;
                    }
                    std.newNum = false;
                    std.pendingCalToClear = true;
                    std.OnceEqual = true;
                } else {
                    if (ans != null) {
                        std.textField1.setText(ans.toPlainString());
                    }
                }
            } else {
                std.textField1.setText("0");
                std.error = false;
            }
        }
    }

    /**
     * to calculate √x
     *
     * @param e   MouseEvent
     * @param std Calculator
     * @author TonyZhan
     */
    public static void sqrt(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans;
            if (!std.error) {
                try {
                    ans = new BigDecimal(str_now).sqrt(new MathContext(16));
                } catch (ArithmeticException ae) {
                    std.label1.setText("");
                    std.textField1.setText("ERROR! Press any key to reset.");
                    std.error = true;
                    return;
                }
                if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                    std.label1.setText("sqrt(" + str_now + ")" + " = " + ans.toPlainString());
                    std.textField1.setText(ans.toPlainString());
                    std.newNum = false;
                    std.pendingCalToClear = true;
                    std.OnceEqual = true;
                } else {
                    std.textField1.setText(ans.toPlainString());
                }
            } else {
                std.textField1.setText("0");
                std.error = false;
            }
        }
    }

    /**
     * to calculate x^2
     *
     * @param e   MouseEvent
     * @param std Calculator
     * @author TonyZhan
     */
    public static void pow2(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            if (!std.error) {
                BigDecimal ans = new BigDecimal(str_now).pow(2, MathContext.DECIMAL128);
                System.out.println(ans);
                if (ans.toPlainString().length() > 10000) {
                    System.out.println("ok");
                    ans = null;
                }
                if (ans == null) {
                    std.label1.setText("");
                    std.textField1.setText("ERROR! Press any key to reset.");
                    std.error = true;
                    return;
                }
                if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                    std.label1.setText("(" + str_now + ")" + "^2" + " = " + ans.toPlainString());
                    std.textField1.setText(ans.toPlainString());
                    std.newNum = false;
                    std.pendingCalToClear = true;
                    std.OnceEqual = true;
                } else {
                    std.textField1.setText(ans.toPlainString());
                }
            } else {
                std.textField1.setText("0");
                std.error = false;
            }
        }
    }

    /**
     * to calculate the floor or ceiling of a number
     *
     * @param e   MouseEvent
     * @param std Calculator
     * @param op  floor or ceiling
     * @author TonyZhan
     */
    public static void floorCeil(MouseEvent e, CalculatorStd std, int op) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans = null;
            if (!std.error) {
                try {
                    if (op == 0)
                        ans = new BigDecimal(str_now).setScale(0, RoundingMode.FLOOR);
                    else if (op == 1)
                        ans = new BigDecimal(str_now).setScale(0, RoundingMode.CEILING);
                } catch (ArithmeticException ae) {
                    std.label1.setText("");
                    std.textField1.setText("ERROR! Press any key to reset.");
                    std.error = true;
                    return;
                }
                if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                    if (op == 0)
                        std.label1.setText("floor(" + str_now + ")" + " = " + ans.toPlainString());
                    else if (op == 1)
                        std.label1.setText("ceiling(" + str_now + ")" + " = " + ans.toPlainString());
                    std.textField1.setText(ans.toPlainString());
                    std.newNum = false;
                    std.pendingCalToClear = true;
                    std.OnceEqual = true;
                } else {
                    std.textField1.setText(ans.toPlainString());
                }
            } else {
                std.textField1.setText("0");
                std.error = false;
            }
        }
    }

    /**
     * to change the number into scientific number.
     *
     * @param e   MouseEvent
     * @param std Calculator
     * @author TonyZhan
     */
    public static void science(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans = new BigDecimal(str_now);
            if (!std.error) {
                try {
                    if (ans.compareTo(new BigDecimal("1E+16")) > 0) {
                        ans = ans.setScale(16 - ans.setScale(0, RoundingMode.HALF_UP).toPlainString().length(), RoundingMode.HALF_UP);
                    }
                } catch (ArithmeticException ae) {
                    std.label1.setText("");
                    std.textField1.setText("ERROR! Press any key to reset.");
                    std.error = true;
                    return;
                }
                if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                    std.label1.setText("scientify(" + str_now + ")" + " = " + ans.stripTrailingZeros().toString());
                    std.textField1.setText(ans.stripTrailingZeros().toString());
                    std.newNum = false;
                    std.pendingCalToClear = true;
                    std.OnceEqual = true;
                } else {
                    std.textField1.setText(ans.stripTrailingZeros().toString());
                }
            } else {
                std.textField1.setText("0");
                std.error = false;
            }
        }
    }

    /**
     * to change the number into plain number
     *
     * @param e   MouseEvent
     * @param std Calculator
     * @author TonyZhan
     */
    public static void plain(MouseEvent e, CalculatorStd std) {
        String str_now = UtilitiesStd.PureNumberWithoutArithmetics(std.textField1.getText());
        String str_equal = UtilitiesStd.PureEqual(std.label1.getText());
        if (e.getButton() == 1) {
            BigDecimal ans = new BigDecimal(str_now);
            if (!std.error) {
                try {
                    ans = ans.stripTrailingZeros();
                } catch (ArithmeticException ae) {
                    std.label1.setText("");
                    std.textField1.setText("ERROR! Press any key to reset.");
                    std.error = true;
                    return;
                }
                if (!str_equal.isEmpty() || std.label1.getText().isEmpty()) {
                    std.label1.setText("plain(" + str_now + ")" + " = " + ans.toPlainString());
                    std.textField1.setText(ans.toPlainString());
                    std.newNum = false;
                    std.pendingCalToClear = true;
                    std.OnceEqual = true;
                } else {
                    std.textField1.setText(ans.toPlainString());
                }
            } else {
                std.textField1.setText("0");
                std.error = false;
            }
        }
    }
}
