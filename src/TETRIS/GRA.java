package TETRIS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GRA extends JFrame{

    public GRA() {
        plansza();
    }

    private void plansza() {

        var tetris = new TETRIS(this);
        add(tetris);
        tetris.start();

        setTitle("Tetris");
        setSize(300, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GRA();
    }
}


