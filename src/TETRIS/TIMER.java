package TETRIS;

import TETRIS.TETRIS;

public class TIMER extends Thread{
    private TETRIS tetriss;

    public TIMER(TETRIS tetriss){
        this.tetriss = tetriss;
    }

    public TIMER() {

    }

   /* public void move() {
        while(true) {
            try {
                tetriss.down();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
