/*
 * Based off the famous game Boggle, virtualizes the environment for the game
 * Stores a 2D array of BogglePieces 
 */

package BoggleSolver;
import java.util.*;

public class Boggle {
    int boardSize; 
    final BogglePiece[][] board;
    
    public static void main(String args[]){
        Boggle boggle = new Boggle(4);
        boggle.buildTestBoard(boggle.boardSize);
        boggle.printBoard();
    }

    public Boggle(int size){
        this.boardSize=size; 
        this.board = new BogglePiece[size][size];
    }
    
    public ArrayList<BogglePiece> getAdjacentPieces(BogglePiece piece){
        ArrayList<BogglePiece> adjacentPieces = new ArrayList<>();
        
        //check north
        if(piece.row+1 < this.boardSize){
            adjacentPieces.add(this.board[piece.row+1][piece.col]);
        }
        
         //check north east
        if(piece.col+1 < this.boardSize && piece.row+1 < this.boardSize){
            adjacentPieces.add(this.board[piece.row+1][piece.col+1]);
        }
        
        //check east
        if(piece.col+1 < this.boardSize){
            adjacentPieces.add(this.board[piece.row][piece.col+1]);
        }
        
        //check south east
        if(piece.col+1 < this.boardSize && piece.row > 0){
            adjacentPieces.add(this.board[piece.row-1][piece.col+1]);
        }
        
        //Check south
        if(piece.row > 0){
            adjacentPieces.add(this.board[piece.row-1][piece.col]);
        }
        
        //check south west
        if(piece.row > 0 && piece.col > 0 ){
            adjacentPieces.add(this.board[piece.row-1][piece.col-1]);
        }
        
        //check west
        if(piece.col > 0 ){
            adjacentPieces.add(this.board[piece.row][piece.col-1]);
        }
        
        //check north west
        if(piece.row+1 < this.boardSize && piece.col > 0){
            adjacentPieces.add(this.board[piece.row+1][piece.col-1]);
        }

        return adjacentPieces;
    }
    
    public BogglePiece getPieceAt(int row, int col){
        //check that piece is in board bounds
        if(col >= 0 && col < this.boardSize && row >= 0 && row < this.boardSize ){
            return(this.board[col][row]);
        } else{
            return null;
        }
    }

    public void buildTestBoard(int size){
        if(size==4){
            char[] testChars = "ATEBFGHIANEORABU".toLowerCase().toCharArray();
            int charIndex = 0;
            for(int i=0; i<this.boardSize; i++){
                for(int j=0; j<this.boardSize; j++){
                   BogglePiece curPiece = new BogglePiece(i,j,testChars[charIndex]);
                   board[i][j] = curPiece;
                   charIndex++;
                }
            }
        }
    }

    public void printBoard(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < this.boardSize; i++){
            for(int j=0; j < this.boardSize; j++){
                sb.append(this.board[i][j].value);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
}
