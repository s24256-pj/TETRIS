package TETRIS;
import java.awt.*;

public class KLOCEK {

        int x, y;

        public int[][] xy;
        public int[][] shape;
        public Color color;

        public KLOCEK(int[][] shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public int[][] getShape(){
            return shape;
        }
        public int getH(){
            return shape.length;
        }
        public int getW(){
            return shape[0].length;
        }
        public int getx(){
            return x;
        }
        public int gety(){
            return y;
        }

        public int down(){
            return y++;
        }

        public Color getColor(){
            return color;
        }

        public int left(){
            return x--;
        }

        public int right(){
            return x++;
        }


        public int stopdown(){

            return y + getH();
        }


    }

