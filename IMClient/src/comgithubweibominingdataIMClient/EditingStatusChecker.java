package comgithubweibominingdataIMClient;


public class EditingStatusChecker implements Runnable {
	
	private ClientView view;

	public EditingStatusChecker(ClientView frame) {
		// TODO Auto-generated constructor stub
		view = frame;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view.updateUsrStatus();
		}
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
