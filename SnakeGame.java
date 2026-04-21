import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

    static class GamePanel extends JPanel implements ActionListener, KeyListener {
        private final int WIDTH = 600;
        private final int HEIGHT = 600;
        private final int CELL_SIZE = 30;
        private final int GRID_WIDTH = WIDTH / CELL_SIZE;
        private final int GRID_HEIGHT = HEIGHT / CELL_SIZE;
        private java.util.List<Point> snake;
        private javax.swing.Timer timer;
        private static final int RIGHT = 0;
        private static final int DOWN = 1;
        private static final int LEFT = 2;
        private static final int UP = 3;
        private int direction = RIGHT;

        public GamePanel() {
            snake = new ArrayList<>();
            snake.add(new Point(8, 10));
            snake.add(new Point(9, 10));
            snake.add(new Point(10, 10));
            timer = new javax.swing.Timer(150, this);
            setFocusable(true);
            addKeyListener(this);
            timer.start();
        }

        private void move() {
            Point head = snake.get(0);
            int newX = head.x;
            int newY = head.y;
            if (direction == RIGHT) {
                newX = (newX + 1) % GRID_WIDTH;
            } else if (direction == LEFT) {
                newX = (newX - 1 + GRID_WIDTH) % GRID_WIDTH;
            } else if (direction == DOWN) {
                newY = (newY + 1) % GRID_HEIGHT;
            } else if (direction == UP) {
                newY = (newY - 1 + GRID_HEIGHT) % GRID_HEIGHT;
            }
            snake.add(0, new Point(newX, newY));
            snake.remove(snake.size() - 1);
            repaint();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            move();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT && direction != LEFT) {
                direction = RIGHT;
            } else if (key == KeyEvent.VK_LEFT && direction != RIGHT) {
                direction = LEFT;
            } else if (key == KeyEvent.VK_DOWN && direction != UP) {
                direction = DOWN;
            } else if (key == KeyEvent.VK_UP && direction != DOWN) {
                direction = UP;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // Not used
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Not used
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