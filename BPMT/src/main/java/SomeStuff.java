
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
    
    
    public static int categorizer(String cat){
        int Id;
        switch(cat){
            case "MotherBoard":
                Id=0;
                break;
            case "CPU":
                Id=1;
                break;
            case "GPU":
                Id=2;
                break;
            case "SSD":
                Id=3;
                break;
            case "HDD":
                Id=4;
                break;
            case "RAM":
                Id=5;
                break;
            case "Power Supply":
                Id=6;
                break;
            case "Mouse":
                Id=7;
            case "Keyboard":
                Id=8;
                break;
            default:
                Id=-1;
                
        }
        return Id;
   
        
    }
    
    public static double properfloat(String a){
         String replace = a.replace(".","");
         String replace1 = replace.replace(",", ".");
         double tmp = 0.0;
         tmp = Double.valueOf(replace1);
            return tmp;
       
            
           
        
        
    }
}
