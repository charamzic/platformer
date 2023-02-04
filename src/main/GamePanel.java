package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private final MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 0.03f, yDir = 0.03f;
    private Color color = new Color(150, 20, 90);
    private Random random;

    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    public void setRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRect();
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

        repaint();
    }

    private void updateRect() {
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRandomColor();
        }

        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }
}
