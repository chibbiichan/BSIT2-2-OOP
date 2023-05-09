//Create Java method(s) to check whether a string is a valid password and provide the  necessary conditional statement if the terms/rules are not followed (Password is not valid).
//  Password rules:
//        A password must have at least ten characters.
//        A password consists of only letters and digits.
//        A password must contain at least two digits.
//  Sample Input and Expected Output:
//        1. A password must have at least ten characters.
//        2. A password consists of only letters and digits.
//        3. A password must contain at least two digits.
//        Input a password: abcd1234
//        Password is not valid.

import java.util.*;
public class PasswordValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a password: ");
        String password = sc.next();

        if (isValidPassword(password)) {
            System.out.println("Password is valid: " + password);
        } else {
            System.out.println("Password is not valid.");
        }
    }

   public static boolean isValidPassword(String password) {
        if (password.length() < 10) {
            return false;
        }

        int letterCount = 0;
        int digitCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                return false;
            }
        }

        return digitCount >= 2;
    }
}