import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SnakeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.setVisible(true);
    }

    static class GamePanel extends JPanel {
        private final int WIDTH = 600;
        private final int HEIGHT = 600;
        private final int CELL_SIZE = 30;
        private final int GRID_WIDTH = WIDTH / CELL_SIZE;
        private final int GRID_HEIGHT = HEIGHT / CELL_SIZE;
        private java.util.List<Point> snake;

        public GamePanel() {
            snake = new ArrayList<>();
            snake.add(new Point(8, 10));
            snake.add(new Point(9, 10));
            snake.add(new Point(10, 10));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // background
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            // grid
            g.setColor(Color.GRAY);
            for (int i = 0; i <= GRID_WIDTH; i++) {
                g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, HEIGHT);
            }
            for (int i = 0; i <= GRID_HEIGHT; i++) {
                g.drawLine(0, i * CELL_SIZE, WIDTH, i * CELL_SIZE);
            }
            // snake
            g.setColor(Color.GREEN);
            for (Point p : snake) {
                g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}