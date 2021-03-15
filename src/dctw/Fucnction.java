/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;

import javax.swing.JPanel;

/**
 *
 * @author DJAWED
 */
public class Fucnction {
    
    
    public static void ChangePanel(JPanel mainPanel ,JPanel panel){
            mainPanel.removeAll();
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    
    
}
