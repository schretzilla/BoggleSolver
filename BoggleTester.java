/*
 * Test Various conditions of the boggle board
 */

package BoggleSolver;
import java.util.*;

public class BoggleTester {
    public static void main(String[] args){
        Boggle boggle = new Boggle(4);
        boggle.buildTestBoard(boggle.boardSize);
        
        boggle.printBoard();
        
       showAdjacent(boggle, 0, 0);
        
       showAdjacent(boggle, 3, 3);
        
       showAdjacent(boggle, 2, 2);
        
    }
    
    public static void showAdjacent(Boggle board, int row, int col){
        BogglePiece startPiece = board.getPieceAt(row, col);
        System.out.println("Piece Value: " + startPiece.value);
        ArrayList<BogglePiece> adjacentPieces = board.getAdjacentPieces(startPiece);
        for(BogglePiece piece : adjacentPieces){
            System.out.print(piece.value);
        }
        System.out.println();
    }
}
