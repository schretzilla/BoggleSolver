/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BoggleSolver;
import java.util.*;
/**
 *
 * @author schretzilla
 */
public class BogglePiece {
    int row;
    int col;
    char value;
    
    public BogglePiece(int row, int col, char value){
        this.row = row;
        this.col = col;
        this.value = value;
    }
}
