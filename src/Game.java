import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Movement> list;

    public Game(String filename) throws IOException {
        list = readMovementsFromFile(filename);
    }
    public static List<Movement> readMovementsFromFile(String filename) throws IOException {
        BufferedReader in = null;
        List<Movement> list = new ArrayList<>();
        try {
            in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String [] items = line.split(",");
                int rowFrom = Integer.parseInt(items[0]);
                int colFrom = Integer.parseInt(items[1]);
                Position from = new Position(rowFrom,colFrom);
                int rowTo = Integer.parseInt(items[2]);
                int colTo = Integer.parseInt(items[3]);
                Position to = new Position(rowTo,colTo);
                Movement movement = new Movement(from,to);
                list.add(movement);
            }
            return list;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
    public List<Movement> getList() {
        return list;
    }
}
