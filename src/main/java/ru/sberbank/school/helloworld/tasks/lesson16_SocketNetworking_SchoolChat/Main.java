package ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat;

import ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat.client.ChatClient;
import ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat.server.ChatServer;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Запустить программу в режиме сервера или клиента? (S(erver) / C(lient))");
        while (true) {
            char answer = Character.toLowerCase(in.nextLine().charAt(0));
            if (answer == 's') {
                new ChatServer();
                break;
            } else if (answer == 'c') {
                new ChatClient();
                break;
            } else {
                System.out.println("Некорректный ввод. Повторите.");

            }
        }

    }

}
