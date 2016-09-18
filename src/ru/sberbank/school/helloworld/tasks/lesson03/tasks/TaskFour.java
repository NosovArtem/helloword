package ru.sberbank.school.helloworld.tasks.lesson03.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskFour {

    public static void main(String[] args) throws IOException {
        List<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TaskOne.PATH))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                arrayList.add(reverseLine(sCurrentLine));
            }
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.println(arrayList.get(i));
        }
    }

    private static String reverseLine(String line) {
        StringBuilder sb = new StringBuilder(line.length() + 1);
        String[] words = line.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}