// Write a java program that accepts two double variable and test if both strictly 0 and 1 and false otherwise.
//   Sample Input:
//        Input first number: 0.45
//        Input first number: 0.99
//
//   Expected Output:
//        true

import java.util.*;
public class BetweenZeroAndOne {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Input first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Input second number: ");
        double num2 = sc.nextDouble();

        boolean result = (num1 > 0 && num1 < 1) && (num2 > 0 && num2 < 1);
        System.out.println(result);
    }
}
