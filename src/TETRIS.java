import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.util.Timer;


public class TETRIS extends JFrame{
    int x = 0;
    int y = 0;
    int c = 10;
    int w = 300;
    int h = 600;
    private Timer timer;


    public TETRIS() {
        setTitle("TETRIS");
        setSize(w,h);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == 0){
                    y=y+30;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT && x != 0){
                    y=y+30;
                    x=x-30;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT && x != 270){
                    y=y+30;
                    x=x+30;
                }

                c = 0;
                repaint();

                if(y == 600){
                    y = 0;
                    x = 0;
                    repaint();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(c==0){
            g2d.clearRect(10,10,300,600);
        }
        g2d.drawRect(x, y, 30, 30);
    }

    public static void main(String[] args) {

        new TETRIS();

    }
}


