//Create a Java method that will convert a floating value to an absolute value.
//    Sample Input and Expected Output:
//        Enter a float number: 34.5
//        Absolute: 34.5

import java.util.*;
public class AbsoluteValueOfFloat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a float number: ");

        float number = sc.nextFloat();

        float absolute = Math.abs(number);
        System.out.println("Absolute: " + absolute);
    }
}

