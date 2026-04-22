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

    static class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
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
        private Point food;
        private Random random;
        private boolean running = true;
        private int score = 0;

        public GamePanel() {
            snake = new ArrayList<>();
            snake.add(new Point(8, 10));
            snake.add(new Point(9, 10));
            snake.add(new Point(10, 10));
            random = new Random();
            spawnFood();
            timer = new javax.swing.Timer(150, this);
            setFocusable(true);
            addKeyListener(this);
            addMouseListener(this);
            requestFocusInWindow();
            timer.start();
        }

        private void spawnFood() {
            do {
                int x = random.nextInt(GRID_WIDTH);
                int y = random.nextInt(GRID_HEIGHT);
                food = new Point(x, y);
            } while (snake.contains(food));
        }

        private void move() {
            Point head = snake.get(0);
            int newX = head.x;
            int newY = head.y;
            if (direction == RIGHT) {
                newX++;
            } else if (direction == LEFT) {
                newX--;
            } else if (direction == DOWN) {
                newY++;
            } else if (direction == UP) {
                newY--;
            }
            if (newX < 0 || newX >= GRID_WIDTH || newY < 0 || newY >= GRID_HEIGHT) {
                gameOver();
                return;
            }
            Point newHead = new Point(newX, newY);
            if (snake.contains(newHead)) {
                gameOver();
                return;
            }
            snake.add(0, newHead);
            if (newHead.equals(food)) {
                score++;
                spawnFood();
            } else {
                snake.remove(snake.size() - 1);
            }
            repaint();
        }

        private void gameOver() {
            running = false;
            timer.stop();
            repaint();
        }

        private void reset() {
            snake.clear();
            snake.add(new Point(8, 10));
            snake.add(new Point(9, 10));
            snake.add(new Point(10, 10));
            direction = RIGHT;
            score = 0;
            spawnFood();
            running = true;
            timer.start();
            requestFocusInWindow();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (running) {
                if (key == KeyEvent.VK_RIGHT && direction != LEFT) {
                    direction = RIGHT;
                } else if (key == KeyEvent.VK_LEFT && direction != RIGHT) {
                    direction = LEFT;
                } else if (key == KeyEvent.VK_DOWN && direction != UP) {
                    direction = DOWN;
                } else if (key == KeyEvent.VK_UP && direction != DOWN) {
                    direction = UP;
                } else if (key == KeyEvent.VK_D && direction != LEFT) {
                    direction = RIGHT;
                } else if (key == KeyEvent.VK_A && direction != RIGHT) {
                    direction = LEFT;
                } else if (key == KeyEvent.VK_S && direction != UP) {
                    direction = DOWN;
                } else if (key == KeyEvent.VK_W && direction != DOWN) {
                    direction = UP;
                }
            } else {
                if (key == KeyEvent.VK_R) {
                    reset();
                }
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
        public void mouseClicked(MouseEvent e) {
            requestFocusInWindow();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // Not used
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Not used
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Not used
        }

        @Override
        public void mouseExited(MouseEvent e) {
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
            if (running) {
                // draw food
                g.setColor(Color.RED);
                g.fillRect(food.x * CELL_SIZE, food.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            } else {
                g.setColor(Color.WHITE);
                g.drawString("Game Over", WIDTH / 2 - 50, HEIGHT / 2 - 20);
                g.drawString("Score: " + score, WIDTH / 2 - 50, HEIGHT / 2);
                g.drawString("Press R to restart", WIDTH / 2 - 80, HEIGHT / 2 + 20);
            }
            // always draw score
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 10, 20);
        }
    }
}