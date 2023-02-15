import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Chess {
    public static void main(String[] args) throws IOException {
        checkArgument(args[0]);
        Board board = new Board(args[2]);
        Game game = new Game(args[0]);
        System.out.println(board);
        Map<Position,Piece> map = board.getMap();
        List<Movement> list = game.getList();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Movement mov = (Movement) it.next();
            Position pos1 = mov.getFrom();
            Position pos2 = mov.getTo();
            Piece piece = map.get(pos1);
            map.remove(pos1);
            map.put(pos2,piece);
            System.out.println(board);
        }



    }
    public static void checkArgument(String... args) {
        if (args.length == 0) {
            System.err.println("Usage: Chess <filename>");
            System.exit(1);
        }
    }
}
