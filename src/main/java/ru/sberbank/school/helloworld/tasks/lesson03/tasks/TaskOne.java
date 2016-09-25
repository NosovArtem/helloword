package ru.sberbank.school.helloworld.tasks.lesson03.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TaskOne {

    public static final String PATH = "C:\\text.txt";

    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        addWordsToSet(set);
        System.out.println(set.size() + " разных слов");
    }

    public static void addWordsToSet(Set<String> set) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(sCurrentLine, " \t\n\r,.");
                while (st.hasMoreTokens()) {
                    set.add(st.nextToken());
                }
            }
        }
    }
}
