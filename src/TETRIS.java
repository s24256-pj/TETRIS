import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class TETRIS extends JFrame {
    int x = 0;
    int y = 0;

    public TETRIS() {
        setTitle("TETRIS");
        setSize(300, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                y=y+30;
                if (e.getKeyCode() == KeyEvent.VK_LEFT && x != 0){
                    x=x-30;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT && x != 270){
                    x=x+30;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x, y, 30, 30);
    }

    public void drawRectangles(Graphics g) {
        super.paint(g);
        paint(g);
    }

    public static void main(String[] args) {

        new TETRIS();

    }
}


