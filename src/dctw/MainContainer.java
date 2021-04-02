/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;
import Views.Acceuil;
import jade.core.ProfileImpl;
import jade.core.Runtime;  
import jade.util.ExtendedProperties;
import jade.util.leap.Properties; 
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
/**
 *
 * @author DJAWED
 */
public class MainContainer {
    public static void main(String[] args) {
        
        // creation de l'interface graphique swing
 Views.Acceuil acceuil=new Acceuil();
 acceuil.setVisible(true);
try{
Runtime runtime=Runtime.instance(); 
Properties properties=new ExtendedProperties();
properties.setProperty("gui","true");
ProfileImpl profileImpl=new ProfileImpl(properties);
//creation du container
AgentContainer container=runtime.createMainContainer(profileImpl);
//ContainerController container = runtime.createAgentContainer(myProfile);


//lancement du container
container.start();
Agent1 agent1= new Agent1();
Agent2 agent2= new Agent2();
Agent3 agent3= new Agent3();
Agent4 agent4= new Agent4();
AgentInitiateur agentInitiateur= new AgentInitiateur();
// creation des agents
agent1.lunchAgent1(container);
agent2.lunchAgent2(container);
agent3.lunchAgent3(container);
agent4.lunchAgent4(container);
agentInitiateur.lunchAgentInitiateur(container);



}
catch(Exception e){  e.printStackTrace(); }
}
}
