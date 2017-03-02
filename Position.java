/*
 * 
 */

package BoggleSolver;

//TODO: Eliminate this class
public class Position {
    int row;
    int col;

    public Position(){
        this.row = 0;
        this.col = 0;
    }
    
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }

    public Position getPositionUp(){
        Position newPosition = new Position(this.row+1, this.col);
        return newPosition;
    }
    
    public Position getPositionNE(){
        Position newPosition = new Position(this.row+1, this.col+1);
        return newPosition;
    }
    
    public Position getPositionRight(){
        Position newPosition = new Position(this.row, this.col+1);
        return newPosition;
    }
    
    public Position getPositionSE(){
        Position newPosition = new Position(this.row-1, this.col+1);
        return newPosition;
    }
    
    public Position getPositionDown(){
        Position newPosition = new Position(this.row-1, this.col);
        return newPosition;
    }
    
    public Position getPositionSW(){
        Position newPosition = new Position(this.row-1, this.col-1);
        return newPosition;
    }
    
    public Position getPositionLeft(){
        Position newPosition = new Position(this.row, this.col-1);
        return newPosition;
    }
    
    public Position getPositionNW(){
        Position newPosition = new Position(this.row+1, this.col-1);
        return newPosition;
    }
    
    public void moveRight(){
        this.col++;
    }
    public void moveLeft(){
        this.col--;
    }
    public void moveUp(){
        this.row++;
    }
    public void moveDown(){
        this.row--;
    }
    public void startOfRow(){
        this.row=0;
    }
}
