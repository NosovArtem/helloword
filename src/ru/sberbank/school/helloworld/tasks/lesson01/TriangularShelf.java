package ru.sberbank.school.helloworld.tasks.lesson01;

import java.util.Scanner;

/*
* http://acm.sgu.ru/lang/problem.php?contest=2&problem=2019
* В единственной строке входных данных записано целое число n (1 ≤ n ≤ 108).
*/

public class TriangularShelf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        double r = (0.5 * (Math.sqrt(8.0 * input + 1.0) - 1.0));
        int result = (int) Math.ceil(r);
        System.out.println(result);
    }
}


