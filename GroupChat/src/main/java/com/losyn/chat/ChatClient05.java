package com.losyn.chat;

import java.util.Scanner;

/**
 * 客户端05
 */
public class ChatClient05 {
    public static void main(String[] args) {
        SimpleChat chat05 = new SimpleChat();
        chat05.start();
        scannerChat(chat05);
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
