package comgithubweibominingdataIMClient;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Enumeration;

import comgithubweibominingdataIMSever.SeverRMI;

public class ClientModel {
	
	protected ClientView view;
	protected ClientControl control;
	protected ClientModelRMI rmiModel;
	
	protected EditingStatusTracker eTracker = new EditingStatusTracker();
    protected ChattingHistory h = new ChattingHistory();
    protected UsersManager m = new UsersManager();
    protected String topic = new String();
    
    protected SeverRMI rmiStub;
    
    protected boolean topicChanges = false;
    protected boolean capturingTopicInput = false;


	public ClientModel() {
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	protected boolean registerUsr() {
		Usr u = rmiModel.RegisterUsrAtSever();
		if (u.getUsrID() < 0){
			return false;
		}
		else {
			m.currentUsr = u;
		    return true;
		}
		
	}
	
	protected void updateView() {
		refreshViewUsr();
		refreshViewUsrsList();
		refreshViewChattingHistory();
		refreshViewTopic();
	}
	
	protected void updateSeverInfo() {
		rmiModel.UpdateInfoFromSever();
	}
	
	protected void setCurrentEditingStatus() {
		if (m.currentUsr.setUsrEditingStatus(eTracker.getEditingStatus(new Date(), view.textMsg.getText().length()))) {
			rmiModel.UpdateUsrEditingStatusToSever(m.currentUsr);
		}
	}
	
	protected void updateTopic() {
		System.out.println("updateTopic");
		System.out.println("Come Here" + "(" + this.view.textTopic.getText() + ")");
		this.topic = this.view.textTopic.getText();
		rmiModel.UpdateTopicToSever(topic);
	}
	
	protected void updateUsrStatus(){
		m.currentUsr.setUsrStatusString((String)this.view.comboBoxStatus.getSelectedItem());
		rmiModel.UpdateUsrStatusToSever(m.currentUsr);
	}
	
	protected void addNewMsg() {
		rmiModel.SendMsgToSever(this.view.textMsg.getText());
		refreshViewMsg();
	}	
	
	protected void refreshViewUsrsList(){	
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
	
	protected void refreshViewMsg() {
		// change the current text message as blank
		this.view.textMsg.setText("");
	}
	
	protected void refreshViewChattingHistory() {
		String list = "";
		Enumeration<String> e = h.chattingHistory.elements();
		while(e.hasMoreElements()) {
			list += (String)e.nextElement() + "\n";
		}
		
		this.view.textChattingHistory.setText(list);
		
	}
	
	protected void refreshViewTopic() {
		if (topicChanges && !capturingTopicInput){
			this.view.textTopic.setText(topic);
		}
		topicChanges = false;
	}
	
	protected void refreshViewUsr() {
		// including usr name, and usr status
		this.view.lblUsrNam.setText(m.currentUsr.getUsrName());		
	}
	
	protected void usrQuit() {
		rmiModel.UserLeaves(m.currentUsr);
	}
	

}
