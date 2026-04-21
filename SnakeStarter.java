import java.awt.*;
import javax.swing.*;

public class SnakeStarter extends JPanel {
    private final int gridSize = 20;
    private final int cellSize = 25;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(22, 28, 39));
        g.fillRect(0, 0, gridSize * cellSize, gridSize * cellSize);
        // draw a green 3-segment snake near the center
        g.setColor(Color.GREEN);
        g.fillRect((gridSize / 2 - 1) * cellSize, (gridSize / 2) * cellSize, cellSize, cellSize);
        g.fillRect((gridSize / 2) * cellSize, (gridSize / 2) * cellSize, cellSize, cellSize);
        g.fillRect((gridSize / 2 + 1) * cellSize, (gridSize / 2) * cellSize, cellSize, cellSize);
 
    }
    // main method to create the window and display the panel
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game Starter");
        SnakeStarter panel = new SnakeStarter();
        frame.add(panel);
        frame.setSize(520, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
