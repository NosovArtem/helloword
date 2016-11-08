package ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat.server;

import ru.sberbank.school.helloworld.tasks.lesson16_SocketNetworking_SchoolChat.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ChatServer {

    // private List<String> listUser;
    private List<ClientConnectionThread> connectionsList =
            Collections.synchronizedList(new ArrayList<ClientConnectionThread>());
    private ServerSocket serverSocket;

    //List<String> listUser
    public ChatServer() {
        //this.listUser = listUser;

        try {
            serverSocket = new ServerSocket(Config.Port);

            while (true) {
                Socket client = serverSocket.accept();// Ожидание новых клиентов

                ClientConnectionThread con = new ClientConnectionThread(client);//Создаем новый поток, которому передаем сокет
                connectionsList.add(con);

                con.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    private void closeAll() {
        try {
            serverSocket.close();

            synchronized (connectionsList) {
                Iterator<ClientConnectionThread> iter = connectionsList.iterator();
                while (iter.hasNext()) {
                    ((ClientConnectionThread) iter.next()).close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("!");
        }
    }


    private class ClientConnectionThread extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private boolean exit = false;

        private String name = "";


        public ClientConnectionThread(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }


        @Override
        public void run() {
            try {
                name = in.readLine();

                sendAllUsersMessage("joined");

                String message = "";
                while (!exit) {
                    message = in.readLine();
                    if (message.equals("exit")) {
                        exit = true;
                        break;//Выходим из цикла "чат".
                    }
                    sendAllUsersMessage(message);
                }

                sendAllUsersMessage(" has left");//Сообщаем всем пользователям о выходе клиента

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        public void sendAllUsersMessage(String sendMessage) {
            synchronized (connectionsList) {
                Iterator<ClientConnectionThread> iter = connectionsList.iterator();
                while (iter.hasNext()) {
                    ((ClientConnectionThread) iter.next()).out.println(name + ": " + sendMessage);
                }
            }
        }


        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                connectionsList.remove(this);
                if (connectionsList.size() == 0) {
                    ChatServer.this.closeAll();
                    System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                // System.err.println("!");
            }
        }
    }

    /*public List<String> getListUser() {
        return listUser;
    }

    public void setListUser(List<String> listUser) {
        this.listUser = listUser;
    }*/
}