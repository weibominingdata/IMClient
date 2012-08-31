package comgithubweibominingdataIMClient;

public class Client {
	private ClientModel model;
	private ClientControl control;
	private ClientView view;
	private EditingStatusChecker editingChecker;
	private Thread editingCheckerThread;

	public Client() {
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
			editingChecker = new EditingStatusChecker(view);
			editingCheckerThread = new Thread(editingChecker);
			
			view.setVisible(true);
			editingCheckerThread.start();
			model.initial();
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
			Client c = new Client(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
