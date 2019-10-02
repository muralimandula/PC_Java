class Rock extends Piece {

    Rock(String pos, Game chess) {
        if (pos == "left") {
            this.position = new Position(0, 1);
            this.isAlive = true;
            this.name = "rockLeft";
            chess.board[0][1].name = this.name;


        } else {
            this.position = new Position(0, 7);
            this.isAlive = true;
            chess.board[0][7] = this;
            this.name = "rockRight";
        }
    }

    Rock(final int r, final int c) {
        this.position = new Position(r, c);
    }

    boolean isValidMove(Position newPosition) {
        
        if ((super.isValidMove(newPosition)) && ((newPosition.column == this.column) || (newPosition.row == this.row))) {
           return true;
        } else {
            return false;
        }
    }
}

class Queen extends Piece {

    Queen(Game chess) {
        chess.board[0][4].name = this.name;
        this.position = new Position(0, 4);
        this.name = "Queen";
    }

    Queen(final int r, final int c, Game chess) {
        chess.board[r][c].name = this.name;
        this.position = new Position(r, c);
        this.name = "Queen";
    }

}


class King extends Piece {
    
    Queen(Game chess) {
        chess.board[0][4].name = this.name;
        this.position = new Position(0, 4);
        this.name = "Queen";
    }

    Queen(final int r, final int c, Game chess) {
        chess.board[r][c].name = this.name;
        this.position = new Position(r, c);
        this.name = "Queen";
    }

    boolean makeMove(Position newPosition, Game chess) {

        if (isValidMove(newPosition)) {

            if(chess.board[newPosition.row][newPosition.column].isAlive) {
                chess.board[newPosition.row][newPosition.column].isAlive = false;
            }

            this.column = newPosition.column;
            this.row = newPosition.row;
            return true;

        } else {
            System.out.println("Unable to make move.");
            return false;
        }
    }
    
    boolean isValidMove(Position newPosition) {

        if (super.isValidMove(newPosition)) {

            if (((newPosition.column == this.column + 1) || (newPosition.column == this.column - 1)) ||  //column
                        ((newPosition.row == this.row + 1) || (newPosition.row == this.row - 1)) ||      //row
                                (validDiagonal(newPosition)) ){         //any of diagonal
                   return true;
            } else {
                return false;
            }
        
        } else {
            return false;
        }
    }


    boolean validDiagonal (Position newPosition) {
        if (((newPosition.column == this.column + 1) && (newPosition.row == this.row + 1)) ||    //top right diagonal
                ((newPosition.column == this.column - 1) && (newPosition.row == this.row - 1)) || //bottom left diagonal

                    ((newPosition.column == this.column + 1) && (newPosition.column == this.row - 1)) ||  //bottom right diagonal
                        ((newPosition.column == this.column - 1) && (newPosition.row == this.row + 1))    //top left diagonal
                                                                                                        ) {
                      return true;
        } else {
            return false;
        }
    }
}

