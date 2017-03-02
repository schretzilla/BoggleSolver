/*
 * Creates the game and solves it
 */

package BoggleSolver;
import java.util.*;
import DataStructures.WordTrie;
public class BoggleSolver {
    
    public static void main(String[] args){
        Boggle boggle = new Boggle(4);
        boggle.buildTestBoard(boggle.boardSize);
        boggle.printBoard();
        
        BoggleSolver solver = new BoggleSolver(boggle);
        solver.findAllSolutions();
        
    }
    
    Boggle board;
    WordTrie availableWords;
    LinkedList<StringBuffer> solutions = new LinkedList<>();
    
    public BoggleSolver(Boggle board){
        this.board = board;
        this.availableWords = new WordTrie();
        this.availableWords.addWordFile("words.txt");
    }
        
    public void findAllSolutions(){
        HashSet<BogglePiece> usedPositions = new HashSet<>();

        //move across all pieces on the boar
        for(int i=0; i<this.board.boardSize; i++){
            for(int j=0; j<this.board.boardSize; j++)
            {
                StringBuffer curWord = new StringBuffer("");
                BogglePiece startPiece = this.board.getPieceAt(i,j);
                solutionScanner(startPiece, curWord, usedPositions);    
            }
        }
            
        for(StringBuffer solution : this.solutions){
            System.out.print(solution +  " ");
        }
    }
    
    //TODO: Build solution Bag to hold solutions and stats at runtime. 
    public void printSolutions(){
        System.out.println("Solution Stats: ");
        System.out.println("Number of Solutions: " + this.solutions.size());
        System.out.println("Printing Solutions");
        for(StringBuffer solution : this.solutions){
            System.out.print(solution + " ");
        }
        
    }
    public void solutionScanner(BogglePiece curPiece, StringBuffer curWord, HashSet<BogglePiece> usedPieces){
        //add piece to used pieces list
        usedPieces.add(curPiece);
        
        //add new letter to word
        curWord.append(curPiece.value);

        //check if curWord is even a prefix
        if(this.availableWords.isPrefix(curWord.toString())){
            
            //check if curWord is a solution
            if(this.availableWords.isWord(curWord.toString())){
                this.solutions.add(curWord);
            }
            //Check all directions recursively
             ArrayList<BogglePiece> adjacentPieces = this.board.getAdjacentPieces(curPiece);
            for(BogglePiece piece : adjacentPieces){
                //check that piece hasn't been used
                if(!usedPieces.contains(piece)){
                    StringBuffer newWord = new StringBuffer(curWord);
                    solutionScanner(piece, newWord, usedPieces);
                }
            }
           
        } //End Checking all directions
        
        //done with current piece, pop it off the list
        usedPieces.remove(curPiece);
    }
    
}


