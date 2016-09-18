package ru.sberbank.school.helloworld.tasks.lesson03.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskThree {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(TaskOne.PATH))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(sCurrentLine, " \t\n\r,.-");
                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    if (map.get(s) == null) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
