package Source.Tools;

public class TImeConverter {
    public class TimeConverter {
        public static void main(String[] args) {
            String result = getLengthConversion("56582", "hours", "years");
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
                case "microseconds":
                    switch (changeUnit) {
                        case "milliseconds":
                            return 0.001;
                        case "seconds":
                            return 1e-6;
                        case "minutes":
                            return 1.6666666666666667e-8;
                        case "hours":
                            return 2.777777777777778e-10;
                        case "days":
                            return 1.1574074074074073e-11;
                        case "weeks":
                            return 1.6534391534391535e-12;
                        case "years":
                            return 3.1709791983764585e-14;
                        default:
                            return 1.0;
                    }
                case "milliseconds":
                    switch (changeUnit) {
                        case "microseconds":
                            return 1000.0;
                        // 添加其他单位的转换因子
                        case "seconds":
                            return 0.001;
                        case "minutes":
                            return 1.6666666666666667e-5;
                        case "hours":
                            return 2.777777777777778e-7;
                        case "days":
                            return 1.1574074074074073e-8;
                        case "weeks":
                            return 1.6534391534391535e-9;
                        case "years":
                            return 3.1709791983764585e-11;
                        default:
                            return 1.0;
                    }
                case "seconds":
                    switch (changeUnit) {
                        case "microseconds":
                            return 1e6;
                        case "milliseconds":
                            return 1000.0;
                        case "minutes":
                            return 0.016666666666666666;
                        case "hours":
                            return 0.0002777777777777778;
                        case "days":
                            return 1.1574074074074073e-5;
                        case "weeks":
                            return 1.6534391534391535e-6;
                        case "years":
                            return 3.1709791983764585e-8;
                        default:
                            return 1.0;
                    }
                case "minutes":
                    switch (changeUnit) {
                        case "microseconds":
                            return 6e7;
                        case "milliseconds":
                            return 60000.0;
                        case "seconds":
                            return 60.0;
                        case "hours":
                            return 0.016666666666666666;
                        case "days":
                            return 6.944444444444445e-4;
                        case "weeks":
                            return 9.920634920634921e-5;
                        case "years":
                            return 1.901010101010101e-6;
                        default:
                            return 1.0;
                    }
                case "hours":
                    switch (changeUnit) {
                        case "microseconds":
                            return 3.6e9;
                        case "milliseconds":
                            return 3.6e6;
                        case "seconds":
                            return 3600.0;
                        case "minutes":
                            return 60.0;
                        case "days":
                            return 0.041666666666666664;
                        case "weeks":
                            return 5.9523809523809526e-3;
                        case "years":
                            return 1.1415525114155251e-4;
                        default:
                            return 1.0;
                    }
                case "days":
                    switch (changeUnit) {
                        case "microseconds":
                            return 8.64e10;
                        case "milliseconds":
                            return 8.64e7;
                        case "seconds":
                            return 86400.0;
                        case "minutes":
                            return 1440.0;
                        case "hours":
                            return 24.0;
                        case "weeks":
                            return 0.14285714285714285;
                        case "years":
                            return 2.73972602739726e-3;
                        default:
                            return 1.0;
                    }
                case "weeks":
                    switch (changeUnit) {
                        case "microseconds":
                            return 6.048e11;
                        case "milliseconds":
                            return 6.048e8;
                        case "seconds":
                            return 604800.0;
                        case "minutes":
                            return 10080.0;
                        case "hours":
                            return 168.0;
                        case "days":
                            return 7.0;
                        case "years":
                            return 1.9178082191780823e-2;
                        default:
                            return 1.0;
                    }
                case "years":
                    switch (changeUnit) {
                        case "microseconds":
                            return 3.1536e13;
                        case "milliseconds":
                            return 3.1536e10;
                        case "seconds":
                            return 3.1536e7;
                        case "minutes":
                            return 525600.0;
                        case "hours":
                            return 8760.0;
                        case "days":
                            return 365.25;
                        case "weeks":
                            return 52.177457;
                        default:
                            return 1.0;
                    }

                default:
                    return 1.0; // 默认情况，不进行转换
            }
        }
    }

}
