package TETRIS;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GRA extends JFrame {

    private JLabel statusbar;

    public GRA() {

        initUI();
    }

    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var tetris = new TETRIS(this);
        add(tetris);
        tetris.start();

        setTitle("Tetris");
        setSize(300, 600);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var grra = new GRA();
            grra.setVisible(true);
        });
    }
}


