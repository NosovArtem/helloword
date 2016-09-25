package ru.sberbank.school.helloworld.tasks.lesson01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
*      http://acm.sgu.ru/lang/problem.php?contest=2&problem=2028
*      Числа 0-4
*/

public class CountNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String srt1 = in.nextLine();
        String str2 = in.nextLine();
        int input = Integer.parseInt(srt1);
        int[] arr = new int[input];

        StringTokenizer st = new StringTokenizer(str2);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = {0, 0, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count[0] += 1;
            } else if (arr[i] == 1) {
                count[1] += 1;
            } else if (arr[i] == 2) {
                count[2] += 1;
            } else if (arr[i] == 3) {
                count[3] += 1;
            } else if (arr[i] == 4) {
                count[4] += 1;
            }
        }
        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0) {
                System.out.println(j + " " + count[j]);
            }
        }
    }
}

