/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import javax.swing.JOptionPane;
/**
 *
 * @author DJAWED
 */
public class Agent3 extends Agent {
    
    private double poids;
    private double p;
    private double q;
    private double v;

    public Agent3(double poids, double p, double q, double v) {
        this.poids = poids;
        this.p = p;
        this.q = q;
        this.v = v;
    }

    public Agent3() {
    }
    
    
    
public void lunchAgent3(jade.wrapper.AgentContainer container){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
 
                try {
                    jade.core.Runtime runtime = jade.core.Runtime.instance();
                    ProfileImpl profileImpl = new ProfileImpl(false);
                    profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
                    AgentController agentController = container.createNewAgent("Agent3", "dctw.Agent3", null);
                    agentController.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
 
            }
        });
    }
    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }
    
    
    
    
    	@Override
	protected void setup() {
			 addBehaviour(new CyclicBehaviour() {
				
				@Override
				public void action() {
					// reception de messages
					ACLMessage message= receive();
					
					if(message != null) {
						JOptionPane.showMessageDialog(null,"Matrice de performance reçue avec succes");
						
					}else block();
				}
			});
}
    
}
