//Create a Java method that will compute the sum of two integers and two doubles separately, and after showing the result of the two sums, compute for the product of the
//sums - the result must be a double data type. Requirement: Use method overloading.
//  Sample Input and Expected Output:
//        Enter first integer:5
//        Enter second integer:5
//        Enter first double: 10.34
//        Enter second double: 10.78
//        Result for sum of integer: 10Result for sum of double: 21.119999999999997
//        Result for product of both sums: 211.2

import java.util.*;
public class SumsofInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first integer:");
        int integer1 = sc.nextInt();

        System.out.println("Enter second integer:");
        int integer2 = sc.nextInt();

        System.out.println("Enter first double:");
        double double1 = sc.nextDouble();

        System.out.println("Enter second double:");
        double double2 = sc.nextDouble();

        int integerSum = sum(integer1, integer2);
        double doubleSum = sum(double1, double2);
        double productOfSums = productOfSums(integerSum, doubleSum);

        System.out.println("Result for sum of integer: " + integerSum);
        System.out.println("Result for sum of double: " + doubleSum);
        System.out.println("Result for product of both sums: " + productOfSums);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double productOfSums(int a, double b) {
        return a * b;
    }
}
