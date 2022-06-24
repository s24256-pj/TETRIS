package TETRIS;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.Timer;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TETRIS.KLOCEK.Shapes;

public class TETRIS extends JPanel {

    private JLabel statusbar;
    int z = 30;
    static int w = 300;
    static int h = 600;
    int x, y;
    int k, x1, y1, x2;
    private KLOCEK Klocek;
    final Random rand = new Random();
    private Timer timer;
    private Shapes[] board;

    public TETRIS(GRA gra) {

        initBoard(gra);
    }

    private void initBoard(GRA gra) {

        setFocusable(true);
        statusbar = gra.getStatusBar();
    }

    private void board() {

        for (int i = 0; i < h * w; i++) {

            board[i] = Shapes.NoShape;
        }
    }

    public void start() {
       /* nowyklocek();

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Klocek.down();

                    if ((y1 == Klocek.gety() && x1 == Klocek.getx()) || Klocek.gety() == 18) {
                        y1 = Klocek.gety() - z;
                        x1 = Klocek.getx();
                        repaint();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Klocek.down();
                    Klocek.left();
                    x2 = Klocek.getx() + 1;

                    if ((y1 == y && x1 == x) || y == 600) {
                        y1 = Klocek.gety() - z;
                        x1 = Klocek.getx() + z;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && Klocek.getx() < 250) {
                    Klocek.right();
                    Klocek.down();
                    x2 = Klocek.getx() - 1;

                    if ((y1 == Klocek.gety() && x1 == Klocek.getx()) || y == 600) {
                        y1 = Klocek.gety() - 30;
                        x1 = Klocek.getx() - 30;
                    }
                }
                repaint();
                System.out.println("y");
                System.out.println(String.valueOf(y));
                System.out.println("x");
                System.out.println(String.valueOf(x));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }*/

    }
    /*@Override
    public void paint(Graphics g) {

        Color magenta = new Color(255,0,255);
        Color pink = new Color(255,175,175);
        Color blue = new Color(0,175,225);
        Color green = new Color(0,225,0);
        Color red = new Color(255,0,0);
        Color yellow = new Color(255, 200, 0);
        Color random = new Color(200, 154, 234);

        for(int i=0;i<h/20;i++){
            for(int j=0;j<w/10;j++){
                g.drawRect(x,y,z,z);
            }
        }

        drawKlocek(g);
        nowyklocek();

       /* switch (k) {
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


        g.drawRect(x, y, 30, 30);
        g.fillRect(x, y, 30, 30);
        g.clearRect(x2-1,y-31,32,32);*/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < h / 20; i++) {
            for (int j = 0; j < w / 10; j++) {
                g.drawRect(x, y, z, z);
            }
        }
        //drawKlocek(g);
    }

    /*private void drawKlocek(Graphics g) {
        int[][] shape = Klocek.getShape();
        for (int i = 0; i < Klocek.getHeight(); i++) {
            for (int j = 0; j < Klocek.getWeight(); j++) {
                if (Klocek.getShape()[i][j] == 1) {
                    int x = (Klocek.getx() + j) * z;
                    int y = (Klocek.gety() + i) * z;
                    g.setColor(Klocek.getColor());
                    g.fillRect(x, y, z, z);
                }
            }
        }*/

    public void nowyklocek() {
        Klocek = new KLOCEK(new int[][]{{1, 1}, {1, 0}, {0, 0}}, Color.pink);
    }

    public static void main(String[] args) {
    }

    ;
}