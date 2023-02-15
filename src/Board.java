import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private Position position;
    private Piece piece;
    private Map<Position, Piece> map;

    public Board(String filename) throws IOException {
        map = readMapFromFile(filename);
    }

    public static Map<Position, Piece> readMapFromFile(String filename) throws IOException {
        Map<Position, Piece> map = new HashMap<>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] items = line.split(",");
                int row = Integer.parseInt(items[0]);
                int col = Integer.parseInt(items[1]);
                int type = Integer.parseInt(items[2]);
                int color = Integer.parseInt(items[3]);
                Position pos = new Position(row, col);
                Piece piece = new Piece(color, type);
                map.put(pos, piece);
            }
            return map;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public Map<Position, Piece> getMap() {
        return map;
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position pos = new Position(row,col);
                if (map.containsKey(pos)) {
                    s += map.get(pos);
                } else {
                    s += ". ";
                }

            }
            s += "\n";
        }
        return s;
    }


}
