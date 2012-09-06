package comgithubweibominingdataIMClient;

import java.util.Date;
import java.util.Enumeration;

public class ClientModel {
	
	protected ClientView view;
	protected ClientControl control;
	
	protected EditingStatusTracker eTracker = new EditingStatusTracker();
    protected ChattingHistory h = new ChattingHistory();
    protected UsersManager m = new UsersManager();
    protected String topic = new String();


	public ClientModel() {
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	protected void initial() {
		updateEditingStatus();
		updateChattingHistory();
		updateTopic();
		updateUsr();
	}
	
	protected void updateEditingStatus(){
		m.currentUsr.setUsrEditingStatus(eTracker.getEditingStatus(new Date(), view.textMsg.getText().length()));
		String list = "";
        list += m.currentUsr;//"("+ Usr.getUsrStatusString(m.currentUsr.getUsrStatus()).charAt(0)+ ")"+ m.currentUsr.getUsrName() + ":"+ m.currentUsr.getUsrEditingStatus() + "\n";        
        Enumeration<Usr> e = m.usrList.elements();
        while(e.hasMoreElements()){
        	Usr temp = (Usr)e.nextElement();
        	if (temp.getUsrID() != m.currentUsr.getUsrID()) {
        		list += temp;//"("+ Usr.getUsrStatusString(temp.getUsrStatus()).charAt(0)+ ")" + temp.getUsrName() + ":" + temp.getUsrEditingStatus() + "\n";
        	}
        }
        this.view.textCollaborativeStatus.setText(list);
	}
	
	protected void updateChattingHistory() {
		String list = "";
		Enumeration<String> e = h.chattingHistory.elements();
		while(e.hasMoreElements()) {
			list += (String)e.nextElement() + "\n";
		}
		
		this.view.textChattingHistory.setText(list);
		
		// change the current text message as blank
		this.view.textMsg.setText("");
		
		
	}
	
	protected void updateTopic() {
		this.view.textTopic.setText(topic);
	}
	
	protected void updateUsr() {
		// including usr name, and usr status
		this.view.lblUsrNam.setText(m.currentUsr.getUsrName());
		m.currentUsr.setUsrStatusString((String)this.view.comboBoxStatus.getSelectedItem());
	}
	
	

}
