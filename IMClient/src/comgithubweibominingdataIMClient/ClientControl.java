package comgithubweibominingdataIMClient;

import java.util.Date;


public class ClientControl {
	
	protected ClientView view;
	protected ClientModel model;
	
	
	public ClientControl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	protected void usrStatusChangeHandler() {
		this.model.updateUsr();
		
	}
	
	protected void newMsgHandler() {
		this.model.h.chattingHistory.add(this.view.textMsg.getText());
		this.model.updateChattingHistory();
		
	}
	
	protected void editingStatusChangeHandler(int event){
		if (event == 0) { // gain focus
			this.model.eTracker.setLastKeyTypedTime(new Date());
		}
		else if (event == 1) { // lose focus
			this.model.eTracker.setLastKeyTypedTime(new Date());
		}
		else if (event == 2){ // typing
			this.model.eTracker.setLastKeyTypedTime(new Date());
		}
		else {
			
		}	
		this.model.updateEditingStatus();
		
	}
	
	protected void topicModifyingHandler() {
		this.model.topic = this.view.textTopic.getText();
		this.model.updateTopic();
	}
	
	
}
