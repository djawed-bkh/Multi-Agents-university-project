/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;

import javax.swing.JPanel;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DJAWED
 */
public class Fucnction extends Agent {
    
    
    public static void ChangePanel(JPanel mainPanel ,JPanel panel){
            mainPanel.removeAll();
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
     
    
    
}
