package sudoku;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Brandon Frale & Ankita Tank
 */
public class GameView extends JFrame {
    
    // -- GUI Components --
    // The top level container for the window.
    private Container container;
    // Game board components.
    private JPanel gameBoard;
    private JPanel subGrids[];
    // Tile indexing is sub-grid major.
    private JLabel tiles[][];
    // Buttons
    private JLabel buttons[];
    private GamePresenter presenter;
    
    // Assets
    private ImageIcon givenTileIcons[];
    private ImageIcon filledTileIcons[];
    private ImageIcon emptyTileIcon;
    private ImageIcon highlightTileIcon;
    
    // Identifiers for the buttons along the right hand side of the window.
    public enum BUTTON {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
                    CLEAR, HINT};
    // TODO - Populate this once menu items have been decided.
    public enum MENU_ITEM {};
    

    //
    public GameView(GamePresenter presenter) {
        this.presenter = presenter;
        loadImages();
        initializeGUI();
        setVisible(true);
    }
    
    
    // Toggle whether the button is enabled.
    public void enableButton(BUTTON button, boolean enable) {
        //TODO
    }
    
    
    // Toggle whether the menu item is enabled.
    public void enableMenuItem(MENU_ITEM item, boolean enable) {
        //TODO
    }
    
    
    // Toggle whether the button is highlighted.
    public void highlightButton(BUTTON button, boolean highlight) {
        //TODO
    }
    
    
    // Set the tile to highlighted.
    public void highlightTile(int subgrid, int tile) {
        if(tile >= 0 && tile <= 8 && subgrid >= 0 && subgrid <= 8) {
            tiles[subgrid][tile].setIcon(highlightTileIcon);
        }
    }
    
    
    /* Change the value in the given tile. If a value is given, somehow indicate
     * that it is seperate from the user's guess. Clears tile highlight. */
    public void setTileValue(int subgrid, int tile, int value, boolean isGiven) {
        if(value >= 0 && value <= 9
        && tile >= 0 && tile <= 8
        && subgrid >= 0 && subgrid <= 8) {
            if(tile == 0) {
                tiles[subgrid][tile].setIcon(emptyTileIcon);
            }else if(isGiven) {
                tiles[subgrid][tile].setIcon(givenTileIcons[value - 1]);
            } else {
                tiles[subgrid][tile].setIcon(givenTileIcons[value - 1]);
            }
        }
    }
    
    
    //
    private void loadImages() {
        // Load tile icons.
        givenTileIcons = new ImageIcon[9];
        filledTileIcons = new ImageIcon[9];
        for(int i = 0; i < 9; i++) {
            givenTileIcons[i] = 
                    new ImageIcon("res/tile_given" + (i + 1) + ".png");
            filledTileIcons[i] = 
                    new ImageIcon("res/tile_filled" + (i + 1) + ".png");
        }
        emptyTileIcon = new ImageIcon("res/tile_empty.png");
        highlightTileIcon = new ImageIcon("res/tile_highlight.png");
        
        // Load Button icons.
        //TODO
    }
    
    
    // Initializes JFrame components.
    private void initializeGUI() {
        container = getContentPane();
        
        /* Box layout constrained on X-Axis puts the buttons and board next to
         * each other. */
        BoxLayout containerLayout = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(containerLayout);
        
        gameBoard = new JPanel();
        gameBoard.setBackground(Color.BLACK);
        
        GridLayout gameBoardLayout = new GridLayout(3,3);
        // Thicker gap between sub-grids.
        gameBoardLayout.setHgap(2);
        gameBoardLayout.setVgap(2);
        
        gameBoard.setLayout(gameBoardLayout);
        
        container.add(gameBoard);
        
        // Populate the grid with sub-grids.
        subGrids = new JPanel[9];
        tiles = new JLabel[9][9];
        
        for(int i = 0; i < 9; i++) {
            JPanel subPanel = new JPanel();
            subPanel.setBackground(Color.BLACK);
            subGrids[i] = subPanel;
            
            GridLayout subLayout = new GridLayout(3, 3);
            // Thinner gap between tiles.
            subLayout.setHgap(1);
            subLayout.setVgap(1);
            
            subGrids[i].setLayout(subLayout);
            
            // Populate the sub-grids with tiles.
            for(int j = 0; j < 9; j++) {
                tiles[i][j] = new JLabel();
                tiles[i][j].setIcon(emptyTileIcon);
                subGrids[i].add(tiles[i][j]);
            }
            
            gameBoard.add(subGrids[i]);
        }
        
        //TODO
        
        pack(); // Resize frame to wrap content.
        setResizable(false); // Game looks really bad when resized.
    }
}
