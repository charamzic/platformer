package main;

public class Game {

        private final GameWindow window;
        private final GamePanel panel;

    public Game() {
        panel = new GamePanel();
        window = new GameWindow(panel);
    }
}
