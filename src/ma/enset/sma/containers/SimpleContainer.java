package ma.enset.sma.containers;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import ma.enset.sma.helpers.GAUtils;
public class SimpleContainer {
    public static void main(String[] args) throws StaleProxyException {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);

        for (int i = 0; i < GAUtils.POPULATION_SIZE; i++) {
            AgentController mainAgent = agentContainer.createNewAgent(String.valueOf(i), ma.enset.sma.agents.IndividualAgent.class.getName(), new Object[]{});
            mainAgent.start();
        }

    }
}
