package TETRIS;

import java.awt.Color;
    public class KLOCEK {

        protected enum Shapes { NoShape, ZShape, SShape, LineShape,
            TShape, SquareShape, LShape, MirroredLShape };
        private Shapes shapee;
        int[][] shape;
        private Color color;
        int x;
        int y;

        public KLOCEK(int[][] shape, Color color){
            this.shape=shape;
            this.color=color;
        }

        private void initShape() {

            coords = new int[4][2];

            coordsTable = new int[][][] {
                    { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
                    { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
                    { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
                    { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
                    { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
                    { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
                    { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
                    { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
            };

            setShape(Shapes.NoShape);
        }

        public int getx(){
            System.out.printf("TO JEST x: ");
            System.out.printf(String.valueOf(x));
            return x;
        }

        public int gety(){
            System.out.printf("to jest y: ");
            System.out.printf(String.valueOf(y));
            return y;
        }


        protected void setShape(Shapes shape) {

            for (int i = 0; i < 4 ; i++) {

                for (int j = 0; j < 2; ++j) {

                    coords[i][j] = coordsTable[shape.ordinal()][i][j];
                }
            }

            pieceShape = shape;
        }


        public Shapes getShape(){
            return shapee;
        }

        public Color getColor(){
            return color;
        }

        public int getHeight() {
            return shape.length;
        }

        public int getWeight() {
            return shape[0].length;
        }

    }
