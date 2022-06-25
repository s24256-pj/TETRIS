package TETRIS;
import java.awt.*;
import java.util.Random;

    public class KLOCEK {

        int x, y;

        protected enum Shapes {jeden, dwa, trzy, cztery, piec, szczesc, siedem, osiem}

        public int[][] xy;
        public int[][] shape;
        public int[][][] tablica;
        public Color color;

        public KLOCEK(int[][] shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public void Shape() {
            xy = new int[4][2];

            tablica = new int[][][]{
                    {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
                    {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
                    {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
                    {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
                    {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                    {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                    {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                    {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
            };
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

        public Color ggetColor(){
            Random rand = new Random();
            int k = rand.nextInt(7);
            Color magenta = new Color(255,0,255);
            Color pink = new Color(255,175,175);
            Color blue = new Color(0,175,225);
            Color green = new Color(0,225,0);
            Color red = new Color(255,0,0);
            Color yellow = new Color(255, 200, 0);
            Color random = new Color(200, 154, 234);

            switch (k) {
                case 5:{
                    return Color.pink;
                }
                case 1:
                    return red;
                case 2:
                    return pink;
                case 3:
                    return green;
                case 4:
                    return blue;
                case 0:
                    return yellow;
                case 6:
                    return magenta;
                default:
                    return random;
            }
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

