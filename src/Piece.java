public class Piece {
    private int color;
    private int type;

    public static final String [] WHITE_PIECES = {"♙ ","♖ ","♘ ","♗ ","♕ ","♔ "};
    public static final String [] BLACK_PIECES = { "♟ ","︎♜ ","♞ ","♝ ","♛ ","♚ "};

    public Piece (int color, int type) {
        switch (color) {
            case 0: this.color = 0;
                break;
            case 1: this.color = 1;
                break;
        }
        switch (type) {
            case 0: this.type = 0;
                break;
            case 1: this.type = 1;
                break;
            case 2: this.type = 2;
                break;
            case 3: this.type = 3;
                break;
            case 4: this.type = 4;
                break;
            case 5: this.type = 5;
                break;
        }

    }


    @Override
    public String toString() {
        if (color == 0) {
            return WHITE_PIECES[type];
        } else {
            return BLACK_PIECES[type];
        }
    }
}
