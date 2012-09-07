package comgithubweibominingdataIMClient;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import comgithubweibominingdataIMSever.SeverRMI;

import saqib.rasul.RmiStarter;

public class ClientStarter extends RmiStarter {

	public ClientStarter() {
		super(Client.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCustomRmiHandling() {
		// TODO Auto-generated method stub
        Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			SeverRMI rmi= (SeverRMI)registry.lookup(SeverRMI.SERVICE_NAME);
			
			new Client(rmi);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientStarter();

	}

}
