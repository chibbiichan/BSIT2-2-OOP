//  Write a Java program that accepts four integers from the user and prints equal if all four are equal, and not equal otherwise.
//      Sample Input:
//          Input first number: 25
//          Input second number: 37
//          Input third number: 45
//          Input fourth number: 23
//
//      Expected Output:
//          Numbers are not equal!

import java.util.*;
public class EqualNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input first number: ");
        int num1 = sc.nextInt();

        System.out.print("Input second number: ");
        int num2 = sc.nextInt();

        System.out.print("Input third number: ");
        int num3 = sc.nextInt();

        System.out.print("Input fourth number: ");
        int num4 = sc.nextInt();

        if (num1 == num2 && num2 == num3 && num3 == num4) {
            System.out.println("Numbers are equal!");
        } else {
            System.out.println("Numbers are not equal!");
        }

    }
}
