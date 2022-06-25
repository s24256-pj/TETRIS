package TETRIS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class TETRIS extends JPanel {
    int z=30;
    int x,y;
    int h=600,w=300;
    int columns =10;
    int rows = 20;
    int cellsize=h/rows;
    private final int time = 300;
    private Timer timer;
    private Color[][] background;
    Random rand = new Random();
    private KLOCEK klocek;

    public void start() {
        timer = new Timer(time, new down());
        timer.start();
        background = new Color[rows][columns];
        nowy();
    }


    public void nowy(){

        nowyklocek();
    }

    public KLOCEK nowyklocek(){

        int k = rand.nextInt(7);
        Color magenta = new Color(255,0,255);
        Color pink = new Color(255,175,175);
        Color blue = new Color(0,175,225);
        Color green = new Color(0,225,0);
        Color red = new Color(255,0,0);
        Color yellow = new Color(255, 200, 0);
        Color random = new Color(200, 154, 234);

        KLOCEK[] tmp = new KLOCEK[7];
        tmp[0] = new KLOCEK(new int[][]{{0, 0}, {0, 0}, {0, 0}, {1, 0}}, pink);
        tmp[1] = new KLOCEK(new int[][]{{0, 0}, {0, 0}, {0, 0}, {1, 1}}, yellow);
        tmp[2] = new KLOCEK(new int[][]{{0, 0}, {0, 0}, {0, 0}, {1, 1}}, red);
        tmp[3] = new KLOCEK(new int[][]{{0, 0}, {0, 0}, {-1, 0}, {-1, 1}}, green);
        tmp[4] = new KLOCEK(new int[][]{{0, 0}, {0, 0}, {0, 1}, {0, 1}}, blue);
        tmp[5] = new KLOCEK(new int[][]{{-1, 0}, {1, 0}, {1, 1}, {0, 1}}, random);
        tmp[6] = new KLOCEK(new int [][]{{0, 0}, {0, 0}, {1, 1}, {1, 1}}, Color.cyan);

        klocek = tmp[k];

        return klocek;
    }

    public TETRIS(GRA gra) {
        initBoard(gra);
    }

    public void initBoard(GRA gra){
        setFocusable(true);
        addKeyListener(new TAdapter());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        drawKlocek(g2d);
        background(g2d);
    }

    public void drawKlocek(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int[][] shape = klocek.getShape();
        for (int i = 0; i < klocek.getH(); i++) {
            for (int j = 0; j < klocek.getW(); j++) {
                if (klocek.getShape()[i][j] == 1) {
                    int x = (klocek.getx() + j) * cellsize;
                    int y = (klocek.gety() + i) * cellsize;
                    g.setColor(klocek.getColor());
                    g.fillRect(x, y, cellsize, cellsize);
                    g.setColor(Color.black);
                    g.drawRect(x,y,cellsize,cellsize);
                }
            }
        }
    }

    private void background(Graphics g){
        Color color;

        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                color=background[i][j];

                if(color != null){
                    int x = j*cellsize;
                    int y = i*cellsize;
                    g.setColor(color);
                    g.fillRect(x,y,cellsize,cellsize);
                    g.setColor(Color.black);
                    g.drawRect(x,y,cellsize,cellsize);
                }
            }
        }

    }

    public void dodown(){
        if(stdown()==false){
            wtlo();
            nowy();
        }
        klocek.down();
        repaint();
    }

    public boolean stdown(){

        if(klocek.stopdown() == rows-1) {
            return false;
        }
        int[][]shape = klocek.getShape();
        int wk = klocek.getW();
        int hk = klocek.getH();

        for (int i = 0; i < wk; i++) {
            for (int j=hk-1; j >=0; j--) {
                if(shape[j][i] != 0){
                    int x = i + klocek.getx();
                    int y = j + klocek.gety() + 1;
                    if(background[y][x] != null) return false;
                    break;
                }
            }
        }
        return true;
    }

    public class down implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            dodown();
        }
    }

    private void wtlo(){

        int[][] shape = klocek.getShape();
        int kh = klocek.getH();
        int kw = klocek.getW();

        int xp = klocek.getx();
        int yp = klocek.gety();

        Color color = klocek.getColor();

        for( int i=0;i<kh;i++){
            for(int j=0;j<kw;j++){
                if(shape[i][j]==1){
                    background[i+yp][j+xp] = color;
                }
            }
        }
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                if(klocek.getx()>0) {
                    klocek.left();
                }
            }


            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(klocek.getx()<8) {
                    klocek.right();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}