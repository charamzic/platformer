package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.DOWN;
import static utils.Constants.Directions.LEFT;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.Directions.UP;
import static utils.Constants.PlayerConstants.IDLE;
import static utils.Constants.PlayerConstants.RUNNING;
import static utils.Constants.PlayerConstants.getSpriteAmount;

public class GamePanel extends JPanel {

    private final MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage image, subImage;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean isMoving = false;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImage();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = image.getSubimage(i * 64, j * 40, 64, 40);
            }
        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/player.png");

        if (is != null) {
            try {
                image = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setPanelSize() {
        final var size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void setDirection(int direction) {
        this.playerDirection = direction;
        isMoving = true;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePosition();
        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 128, 80, null);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (isMoving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }

    private void updatePosition() {
        if (isMoving) {
            switch (playerDirection) {
                case LEFT -> xDelta -= 4;
                case UP -> yDelta -= 4;
                case RIGHT -> xDelta += 4;
                case DOWN -> yDelta += 4;
            }
        }
    }
}
