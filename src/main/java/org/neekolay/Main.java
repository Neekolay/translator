package org.neekolay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String text = reader.readLine();
                if (text.equals("stop")) return;

                if (!text.trim().equals("")) {
                    String result = Translator.translate(text);
                    if (result != null) {
                        System.out.println(result);
                    }
                } else {
                    System.out.println("Empty input");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
