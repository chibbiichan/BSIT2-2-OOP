// Write a java program that takes a number as input and prints the multiplication table up to 10.
//   Sample Input:
//        Input a number: 8
//
//   Expected Output:
//        8 x 1 = 1
//        8 x 2 = 16
//        8 x 3 = 24
//        ...
//        8 x 10 = 80

import java.util.*;
public class MultiplicationTable {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");

        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            int product = num * i;
            System.out.println(num + " x " + i + " = " + product);
        }

    }
}
