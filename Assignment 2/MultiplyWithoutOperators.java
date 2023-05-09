//Create a Java method that will multiply two integers without multiplication, division, bitwise operators, and loops. (Tip: use recursion)
//    Sample Input and Expected Output:
//        Enter your multiplicand: 40
//        Enter your multiplier: 5
//        Product: 200

import java.util.*;
public class MultiplyWithoutOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your multiplicand: ");
        int multiplicand = sc.nextInt();
        System.out.print("Enter your multiplier: ");
        int multiplier = sc.nextInt();

        int product = multiplyRecursive(multiplicand, multiplier);
        System.out.println("Product: " + product);
    }

    public static int multiplyRecursive(int multiplicand, int multiplier) {
        if (multiplier == 0 || multiplicand == 0) {
            return 0;
        } else if (multiplier > 0) {
            return multiplicand + multiplyRecursive(multiplicand, multiplier - 1);
        } else {
            return -multiplyRecursive(-multiplicand, -multiplier);
        }
    }
}

