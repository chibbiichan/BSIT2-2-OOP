//Create a Java method that will count the number of words in the provided string and will ask for an input from the user for a word to replace in the given string and print the  result in uppercase.
//    Sample Input and Expected Output:
//        Enter your sentence: The quick brown fox jumps over the lazy dog.
//        What is the word you want to replace? dog
//        What word do you want for replacement? cat
//        Result:
//        Number of words in the string: 9
//        Revised sentence: THE QUICK BROWN FOX JUMPS OVER THE LAZY CAT.

import java.util.*;
public class WordReplacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your sentence: ");
        String sentence = sc.nextLine();
        System.out.print("What is the word you want to replace? ");
        String wordToReplace = sc.nextLine();
        System.out.print("What word do you want for replacement? ");
        String replacementWord = sc.nextLine();

        int count = 0;
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            if (word.equals(wordToReplace)) {
                count++;
            }
        }
        System.out.println("Number of words in the string: " + words.length);
        String revisedSentence = sentence.replaceAll(wordToReplace, replacementWord).toUpperCase();
        System.out.println("Revised sentence: " + revisedSentence);
    }
}
