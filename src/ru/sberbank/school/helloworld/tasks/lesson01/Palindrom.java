package ru.sberbank.school.helloworld.tasks.lesson01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
http://acm.sgu.ru/lang/problem.php?contest=2&problem=2024
input.txt
3
1 2 2
*/

public class Palindrom {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int i1 = Integer.parseInt(str1);
        int[] arr = new int[i1];

        StringTokenizer st = new StringTokenizer(str2);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}