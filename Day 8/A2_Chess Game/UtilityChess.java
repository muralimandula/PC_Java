class Game {
    Piece[][] board;
    // Constructor creates an empty board
    Game() {
      this.board = new Piece[8][8];
    }

    public Piece getPiece(int r, int c) {
        return this.board[r][c];
    }
}
  
class Piece {
    String name = "";
    Position position;
    boolean isAlive;
    
    boolean isValidMove(Position newPosition) {
        if (newPosition.row > 0 && newPosition.column > 0 && newPosition.row < 8 && newPosition.column < 8) {
            return true;
        } else {
            return false;
        }
    }

    boolean makeMove(Position newPosition, Game chess) {
        this.position = newPosition;
        return true;
// 
// 
//         
    }

    String getName() {
        return this.name;
    }
}

class Position {
    int row;
    int column;
    // Constructor using row and column values
    Position(int r, int c) {
        this.row = r;
        this.column = c;
    }
}

final class UtilityChess {

    public static void main(String[] args) {

        Game chess = new Game();

        Rock rockLeft = new Rock("left", chess);    //creates at (0,1)
        Rock rockRight = new Rock("right", chess);  //creates at (0,7)

        Queen queen = new Queen(chess);
        King king = new King(chess);


        Position testPosition = new Position(3, 10);

        if (queen.makeMove(testPosition, chess)) {

            chess.board[testPosition.row][testPosition.column] = queen;
            System.out.println("Yes, I can move there.");
        } else {
            System.out.println("Nope, can't do!");
        }
    }
}