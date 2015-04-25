package com.losyn.chat.server;

import java.util.Scanner;

/**
 * 客户端06
 */
public class ChatClient06 {
    public static void main(String[] args) {
        SimpleChat chat06 = new SimpleChat();
        chat06.start();
        scannerChat(chat06);
    }

    private static void scannerChat(SimpleChat chat01){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            System.out.flush();
            String line = scanner.next();
            if (line.startsWith("quit") || line.startsWith("exit")) {
                System.exit(-1);
                break;
            }
            chat01.sendMessage(null, line);
        }
    }
}
