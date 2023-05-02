// Write a java program that takes two number as input and displays the product of two numbers.
//   Sample Input:
//        Enter first number: 25
//        Enter second number: 5
//
//   Expected Output:
//        25 x 5 = 125

import java.util.*;
public class ProductOfTwoNumbers {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.print("Input the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Input the second number: ");
        int num2 = sc.nextInt();

        int product = num1 * num2;
        System.out.println(num1 + " x " + num2 + " = " +product);
    }
}
