package comgithubweibominingdataIMClient;

public class Client {
	private ClientView frame = new ClientView();
	private EditingStatusChecker editingChecker = new EditingStatusChecker(frame);
	private Thread editingCheckerThread = new Thread(editingChecker);

	public Client() {
		// TODO Auto-generated constructor stub
		try {
			frame.setVisible(true);
			editingCheckerThread.start();
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
