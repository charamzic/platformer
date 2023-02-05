package main;

import javax.swing.*;

public class GameWindow {

    private final JFrame jFrame;

    public GameWindow(GamePanel panel) {
        this.jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
