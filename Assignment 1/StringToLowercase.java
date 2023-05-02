// Write a java program to convert a string into lowercase.
//   Sample Input:
//        OVER Input a String: THE QUICK BROWN FOX JUMPS THE LAZY DOG.
//
//   Expected Output:
//        the quick brown fox jump the lazy dog.

import java.util.*;

public class StringToLowercase {
    public static void main(String[] args) {
        String uppStr;

       Scanner sc= new Scanner(System.in);

        System.out.print("Input a String: ");
        uppStr = sc.nextLine();

        String uppStr2 = uppStr.toLowerCase();
        System.out.println(uppStr2);
    }
}

