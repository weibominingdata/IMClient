package comgithubweibominingdataIMClient;

import java.util.Date;

public class ClientControl {
	
	protected ClientView view;
	protected ClientModel model;
	
	protected EditingStatusTracker eTracker = new EditingStatusTracker();

	public ClientControl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	protected void updateUsrStatus() {
		checkSetEditingStatus();
	}
	
	protected void updateChattingHistory() {
		
	}
	
	protected void checkSetEditingStatus(){
        view.textCollaborativeStatus.setText("Alice: " + eTracker.getEditingStatus(new Date(), view.textMsg.getText().length()) + "\n");
	}
	
	
	
}
