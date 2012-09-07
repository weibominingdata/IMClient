package comgithubweibominingdataIMClient;


public class StatusChecker implements Runnable {
	
	private ClientView view;

	public StatusChecker(ClientView frame) {
		// TODO Auto-generated constructor stub
		view = frame;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view.model.updateSeverInfo();
			view.model.setCurrentEditingStatus();
			view.model.updateView();
		}
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
