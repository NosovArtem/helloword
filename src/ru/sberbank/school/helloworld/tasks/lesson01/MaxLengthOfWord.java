package ru.sberbank.school.helloworld.tasks.lesson01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* http://acm.sgu.ru/lang/problem.php?contest=2&problem=2038
*   input.txt            output.txt
*   Vasya is a boy.       5
*/

public class MaxLengthOfWord {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String text = in.nextLine();
        String[] test = text.trim().split("[^a-zA-Z]");

        int maxLengthOfWord = 0;
        for (int i = 0; i < test.length; i++) {
            if (test[i].length() > maxLengthOfWord) {
                maxLengthOfWord = test[i].length();
            }
        }
        System.out.println(maxLengthOfWord);
    }
}




