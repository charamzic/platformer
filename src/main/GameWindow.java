package main;

import javax.swing.*;

public class GameWindow {

    private final JFrame jFrame;

    public GameWindow(GamePanel panel) {
        this.jFrame = new JFrame();

        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
