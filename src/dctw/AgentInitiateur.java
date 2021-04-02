/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DJAWED
 */
public class AgentInitiateur extends Agent{

    public AgentInitiateur() {
    }
    
   
    
    
    public void lunchAgentInitiateur(jade.wrapper.AgentContainer container){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
 
                try {
                    jade.core.Runtime runtime = jade.core.Runtime.instance();
                    ProfileImpl profileImpl = new ProfileImpl(false);
                    profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
                    AgentController agentController = container.createNewAgent("AgentInitiateur", "dctw.AgentInitiateur", null);
                    agentController.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
 
            }
        });
    }
   
    
    public void SendMatricePerformance(){
        System.out.println("emetteur: ON");
      ACLMessage message = new ACLMessage(ACLMessage.INFORM);
      message.addReceiver(new AID("Agent1", AID.ISLOCALNAME));
      message.setContent("this is une matrice de perfor");
      send(message);
        
    }
}
