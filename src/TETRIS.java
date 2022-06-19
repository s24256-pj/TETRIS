import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.Random;

public class TETRIS extends JFrame{
    int x = 30;
    int y = 30;
    int w = 300;
    int h = 600;
    int k,x1,y1,x2;
    final Random rand = new Random();
    private Timer timer;


    public TETRIS() {
        setTitle("TETRIS");
        setBackground(Color.WHITE);
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

                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_SPACE){
                    y = y + 30;
                    x2=x;
                    klocek();
                    if((y1==y && x1 == x )|| y == 600){
                        y1 = y - 30;
                        x1 = x;
                        newgame();
                    }

                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT && x > 10) {
                    y = y + 30;
                    x = x - 30;
                    x2 = x + 30;
                    klocek();

                    if((y1==y && x1 == x )|| y == 600){
                        y1 = y - 30;
                        x1 = x + 30;
                        newgame();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && x < 250){
                    x = x + 30;
                    y = y +30;
                    x2 = x - 30;
                    klocek();

                    if((y1==y && x1 == x )|| y == 600){
                        y1 = y - 30;
                        x1 = x - 30;
                        newgame();
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }

    public void newgame(){
        k = rand.nextInt(6);
        x = 30;
        y = 30;
        klocek();
    }

    public void klocek() {
        repaint();
    }
        /*for(int i=1;i<4;i++){
            x = x*i;
            repaint();
    }*/

    @Override
    public void paint(Graphics g) {

        Color magenta = new Color(255,0,255);
        Color pink = new Color(255,175,175);
        Color blue = new Color(0,175,225);
        Color green = new Color(0,225,0);
        Color red = new Color(255,0,0);
        Color yellow = new Color(255, 200, 0);
        Color random = new Color(200, 154, 234);

        Graphics2D g2d = (Graphics2D) g;

        switch (k) {
            case 5:{
                g.setColor(random);
                for(int i=0;i<4;i++){
                    if(i==0){
                        g2d.fillRect(x, y, 29, 31);
                        g2d.drawRect(x, y, 29, 29);
                        g2d.clearRect(x2-1,y-31,32,32);
                    }
                    if(i==1){
                        g2d.fillRect(x+30, y+30, 29, 29);
                        g2d.drawRect(x+30, y+30, 29, 29);
                        g2d.clearRect(x2-29,y-1,32,32);
                    }
                    if(i==2){
                        g2d.fillRect(x+30, y, 29, 29);
                        g2d.drawRect(x+30, y, 29, 29);
                        g2d.clearRect(x2-29,y-31,32,32);
                    }
                    if(i==3){
                        g2d.fillRect(x, y+30, 29, 29);
                        g2d.drawRect(x, y+30, 29, 29);
                        g2d.clearRect(x2-1,y-1,32,32);
                    }

                }
                break;

            }
            case 1:
                g.setColor(magenta);
                break;
            case 2:
                g.setColor(pink);
                break;
            case 3:
                g.setColor(green);
                break;
            case 4:
                g.setColor(blue);
                break;
            case 0:
                g.setColor(yellow);
                break;
            case 6:
                g.setColor(red);
                break;
            default:
                g.setColor(random);
        }

        g2d.drawRect(x, y, 30, 30);
        g2d.fillRect(x, y, 30, 30);
        g2d.clearRect(x2-1,y-31,32,32);
    }

    public static void main(String[] args) {


        new TETRIS();

    }

}


