package TETRIS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import TETRIS.KLOCEK.Shapes;


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
    int k = rand.nextInt(6);
    private KLOCEK klocek;
    private Shapes[] board;

    public void start() {
        timer = new Timer(time, new down());
        timer.start();
        nowy();

        background = new Color[rows][columns];
    }

    public void nowy(){
        klocek = new KLOCEK(new int [][]{{0, 0}, {0, 0}, {0, 0}, {1, 0}}, Color.pink);
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
                }
            }
        }

    }

    private void drawbackklocek(Graphics g, Color color, int x,int y){
        g.setColor(color);
        g.fillRect(x,y,cellsize,cellsize);
    }

    public void dodown(){
        if(stdown()==false){
            nowy();
        }
        klocek.down();
        repaint();
    }

    public boolean stdown(){

        if(klocek.stopdown() == rows-1) {
            wtlo();
            return false;
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
                klocek.left();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                klocek.right();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}