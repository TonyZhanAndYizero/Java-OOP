package Source.Tools;

public class LengthConverter {
    public static void main(String[] args) {
        String result = getLengthConversion("790000000000000", "nm", "nmi");
        System.out.println(result);
    }

    public static String getLengthConversion(String number, String originUnit, String changeUnit) {
        try {
            // 将输入的字符串转换为长整型数字
            long originalNumber = Long.parseLong(number);
            // 单位转换
            double conversionFactor = getConversionFactor(originUnit, changeUnit);
            System.out.println("conversion factor:" + conversionFactor);
            double convertedNumber = (double) (originalNumber * conversionFactor);
            // 构造输出字符串
            return convertedNumber + changeUnit;
        } catch (NumberFormatException e) {
            return "Invalid input: " + e.getMessage();
        }
    }

    private static double getConversionFactor(String originUnit, String changeUnit) {
        // 在此添加不同单位之间的转换因子
        switch (originUnit) {
            case "nm":
                switch (changeUnit) {
                    case "um":
                        return 0.001;
                    case "mm":
                        return 0.000001;
                    case "cm":
                        return 0.0000001;
                    case "m":
                        return 0.000000001;
                    case "km":
                        return 0.000000000001;
                    case "in":
                        return 3.937007874015748e-8;
                    case "ft":
                        return 3.2808398950131235e-9;
                    case "yd":
                        return 1.0936132983377078e-9;
                    case "mi":
                        return 6.21371192237334e-13;
                    case "nmi":
                        return 5.399568034557236e-13;
                    default:
                        return 1.0;
                }
            case "um":
                switch (changeUnit) {
                    case "nm":
                        return 1000.0;
                    case "mm":
                        return 0.001;
                    case "cm":
                        return 0.0001;
                    case "m":
                        return 0.000001;
                    case "km":
                        return 1e-9;
                    case "in":
                        return 3.937007874015748e-5;
                    case "ft":
                        return 3.2808398950131235e-6;
                    case "yd":
                        return 1.0936132983377078e-6;
                    case "mi":
                        return 6.21371192237334e-10;
                    case "nmi":
                        return 5.399568034557236e-10;
                    default:
                        return 1.0;
                }
            case "mm":
                switch (changeUnit) {
                    case "um":
                        return 1000.0;
                    case "nm":
                        return 1e6;
                    case "cm":
                        return 0.1;
                    case "m":
                        return 0.001;
                    case "km":
                        return 1e-6;
                    case "in":
                        return 0.03937007874015748;
                    case "ft":
                        return 0.0032808398950131235;
                    case "yd":
                        return 0.0010936132983377078;
                    case "mi":
                        return 6.21371192237334e-7;
                    case "nmi":
                        return 5.399568034557236e-7;
                    default:
                        return 1.0;
                }
            case "cm":
                switch (changeUnit) {
                    case "mm":
                        return 10.0;
                    case "um":
                        return 10000.0;
                    case "nm":
                        return 1e7;
                    case "m":
                        return 0.01;
                    case "km":
                        return 1e-5;
                    case "in":
                        return 0.3937007874015748;
                    case "ft":
                        return 0.032808398950131235;
                    case "yd":
                        return 0.010936132983377078;
                    case "mi":
                        return 6.21371192237334e-6;
                    case "nmi":
                        return 5.399568034557236e-6;
                    default:
                        return 1.0;
                }
            case "m":
                switch (changeUnit) {
                    case "cm":
                        return 100.0;
                    case "mm":
                        return 1000.0;
                    case "um":
                        return 1e6;
                    case "nm":
                        return 1e9;
                    case "km":
                        return 0.001;
                    case "in":
                        return 39.37007874015748;
                    case "ft":
                        return 3.2808398950131235;
                    case "yd":
                        return 1.0936132983377078;
                    case "mi":
                        return 6.21371192237334e-4;
                    case "nmi":
                        return 5.399568034557236e-4;
                    default:
                        return 1.0;
                }
            case "km":
                switch (changeUnit) {
                    case "cm":
                        return 100000.0;
                    case "mm":
                        return 1e6;
                    case "um":
                        return 1e9;
                    case "nm":
                        return 1e12;
                    case "m":
                        return 1000.0;
                    case "in":
                        return 39370.07874015748;
                    case "ft":
                        return 3280.8398950131235;
                    case "yd":
                        return 1093.6132983377078;
                    case "mi":
                        return 0.6213711922373339;
                    case "nmi":
                        return 0.5399568034557236;
                    default:
                        return 1.0;
                }
            case "in":
                switch (changeUnit) {
                    case "cm":
                        return 2.54;
                    case "mm":
                        return 25.4;
                    case "um":
                        return 25400.0;
                    case "nm":
                        return 25400000.0;
                    case "m":
                        return 0.0254;
                    case "km":
                        return 2.54e-5;
                    case "ft":
                        return 0.08333333333333333;
                    case "yd":
                        return 0.027777777777777776;
                    case "mi":
                        return 1.5782828282828283e-5;
                    case "nmi":
                        return 1.3714902807775378e-5;
                    default:
                        return 1.0;
                }
            case "ft":
                switch (changeUnit) {
                    case "cm":
                        return 30.48;
                    case "mm":
                        return 304.8;
                    case "um":
                        return 304800.0;
                    case "nm":
                        return 304800000.0;
                    case "m":
                        return 0.3048;
                    case "km":
                        return 3.048e-4;
                    case "in":
                        return 12.0;
                    case "yd":
                        return 0.3333333333333333;
                    case "mi":
                        return 1.893939393939394e-4;
                    case "nmi":
                        return 1.6457883369335275e-4;
                    default:
                        return 1.0;
                }
            case "yd":
                switch (changeUnit) {
                    case "cm":
                        return 91.44;
                    case "mm":
                        return 914.4;
                    case "um":
                        return 914400.0;
                    case "nm":
                        return 914400000.0;
                    case "m":
                        return 0.9144;
                    case "km":
                        return 9.144e-4;
                    case "in":
                        return 36.0;
                    case "ft":
                        return 3.0;
                    case "mi":
                        return 0.0005681818181818182;
                    case "nmi":
                        return 0.0004937365010799136;
                    default:
                        return 1.0;
                }
            case "mi":
                switch (changeUnit) {
                    case "cm":
                        return 160934.4;
                    case "mm":
                        return 1609344.0;
                    case "um":
                        return 1609344000.0;
                    case "nm":
                        return 1609344000000.0;
                    case "m":
                        return 1609.344;
                    case "km":
                        return 1.609344;
                    case "in":
                        return 63360.0;
                    case "ft":
                        return 5280.0;
                    case "yd":
                        return 1760.0;
                    case "nmi":
                        return 0.868976241900648;
                    default:
                        return 1.0;
                }
            case "nmi":
                switch (changeUnit) {
                    case "cm":
                        return 185200.0;
                    case "mm":
                        return 1852000.0;
                    case "um":
                        return 1852000000.0;
                    case "nm":
                        return 1852000000000.0;
                    case "m":
                        return 1852.0;
                    case "km":
                        return 1.852;
                    case "in":
                        return 72913.38582677165;
                    case "ft":
                        return 6076.115485564304;
                    case "yd":
                        return 2025.3718285214387;
                    case "mi":
                        return 1.150779448023542;
                    default:
                        return 1.0;
                }
            default:
                return 1.0;
        }
    }
}
