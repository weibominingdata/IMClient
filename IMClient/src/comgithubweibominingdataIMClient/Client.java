package comgithubweibominingdataIMClient;

import comgithubweibominingdataIMSever.SeverRMI;

public class Client {
	private ClientModel model;
	private ClientControl control;
	private ClientView view;
	private StatusChecker statusChecker;
	private Thread editingCheckerThread;
	private ClientModelRMI modelRMI;

	public Client(SeverRMI rmi) {
		// TODO Auto-generated constructor stub
		try {
			model = new ClientModel();
			control = new ClientControl();
			model.control = control;
			control.model = model;
			view = new ClientView();
			view.model = model;
			view.control = control;
			model.view = view;
			control.view = view;
			statusChecker = new StatusChecker(view);
			editingCheckerThread = new Thread(statusChecker);
			model.rmiStub = rmi;
			modelRMI = new ClientModelRMI(model);
			model.rmiModel = modelRMI;
			if (!model.registerUsr()) {
				System.err.println("User register fails");
			}
			else {
				view.setVisible(true);
				editingCheckerThread.start();
				model.updateView();			
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
