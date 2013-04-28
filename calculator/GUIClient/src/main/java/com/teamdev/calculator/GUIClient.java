package com.teamdev.calculator;

import java.io.IOException;

public class GUIClient {
    public static void run() {
        MainFrame mainFrame = new MainFrame("Calculator v.1.0");
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
            GUIClient.run();
        }
    }

