public class FindMinMax {
    public static void main(String[] args) {
        double temp, max, min;
        double d1 = 1, d2 = -9.9, d3 = 96.9;
        temp = d1 > d2 ? d1 : d2;
        temp = temp > d3 ? temp : d3;
        max = temp;
        temp = d1 < d2 ? d1 : d2;
        temp = temp < d3 ? temp : d3;
        min = temp;
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
