package ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat.client;

import ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat.Config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ChatClient {
    private static final String DEFAULT_HOST = "localhost"; // 127.0.0.1

    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;


    private static String username;


    public ChatClient() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Your name: ");
        username = scan.nextLine();
        System.out.println("Welcome, " + username + ".");

        System.out.println("Введите IP для подключения к серверу.");
        System.out.println("Формат: xxx.xxx.xxx.xxx");
        String ip = scan.nextLine();


        try {

            socket = new Socket(DEFAULT_HOST, Config.Port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Отправить ник:");
            out.println(username);


            Resender resend = new Resender();
            resend.start();


            String str = "";
            while (!str.equals("exit")) {
                str = scan.nextLine();
                out.println(str);
            }
            resend.setStop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("��⮪� �� �뫨 �������!");
        }
    }


    private class Resender extends Thread {

        private boolean stoped;


        public void setStop() {
            stoped = true;
        }


        @Override
        public void run() {
            try {
                while (!stoped) {
                    String str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при получении сообщения.");
                e.printStackTrace();
            }
        }
    }

}
