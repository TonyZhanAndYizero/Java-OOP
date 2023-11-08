package RUNOOB;

import java.util.Scanner;

public class ArrayTest {
    public static int ArrayNum = 0;
    private int[] arr = new int[15];

    public ArrayTest() {
        ArrayNum++;
    }

    public void input() {
        for (int i = 0; i < 15; i++) {
            Scanner sc = new Scanner(System.in);
            this.arr[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        ArrayTest a = new ArrayTest();
        a.input();
        System.out.println(ArrayNum);
        for (int i = 0; i < 15; i++) {
            System.out.print(a.arr[i]);
            System.out.print(' ');
        }
    }
}
