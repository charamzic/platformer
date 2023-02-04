package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private final GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP -> {
                gamePanel.changeYDelta(-5);
            }
            case KeyEvent.VK_LEFT -> {
                gamePanel.changeXDelta(-5);
            }
            case KeyEvent.VK_DOWN -> {
                gamePanel.changeYDelta(5);
            }
            case KeyEvent.VK_RIGHT -> {
                gamePanel.changeXDelta(5);
            }
        }
    }
}
