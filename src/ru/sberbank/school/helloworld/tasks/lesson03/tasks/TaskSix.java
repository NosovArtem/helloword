package ru.sberbank.school.helloworld.tasks.lesson03.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TaskSix {

    public static void main(String[] args) throws IOException {
        List<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TaskOne.PATH))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                arrayList.add(sCurrentLine);
            }
        }

        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> numberLines = new ArrayList<>();
            System.out.println("В текстовом файле " + arrayList.size() + " строк(и). Укажите колличество строк на вывыод:");
            int numberString = sc.nextInt();
            int j = 0;
            while (j < numberString) {
                System.out.print("Введите номер строки: ");
                int n = sc.nextInt();
                if (n <= arrayList.size()) {
                    numberLines.add(n);
                    j++;
                } else {
                    System.out.println("Вы ввели слишком большое число");
                }
            }
            for (int i = 0; i < numberLines.size(); i++) {
                System.out.println(arrayList.get(numberLines.get(i) - 1));
            }
        }
    }
}

