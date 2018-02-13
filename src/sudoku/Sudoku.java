/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import javax.swing.JFrame;

/**
 *
 * @author Brandon
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GameModel model = new GameModel();
        GamePresenter presenter = new GamePresenter(model);
        GameView view = new GameView(presenter);
        
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
