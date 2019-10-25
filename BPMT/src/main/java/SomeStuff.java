
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denizcan
 */
public class SomeStuff {
    
     public static void switchPanels(JPanel panel,javax.swing.JLayeredPane layeredPane){
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
    
    
    
}
