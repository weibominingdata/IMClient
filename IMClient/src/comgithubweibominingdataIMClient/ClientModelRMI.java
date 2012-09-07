package comgithubweibominingdataIMClient;

import java.rmi.RemoteException;
import java.util.Vector;

public class ClientModelRMI {
	
	protected ClientModel m;

	public ClientModelRMI(ClientModel m) {
		// TODO Auto-generated constructor stub
		this.m = m;
	}
	
	protected void SendMsgToSever(String msg) {
		try {
			m.rmiStub.usrUpdateMessage(m.m.currentUsr, msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Usr RegisterUsrAtSever() {
		try {
			Usr u =	m.rmiStub.usrRegister();
			System.err.println(u.getUsrName());
			return u;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Usr();
		
	}
	
	protected void UserLeaves(Usr u) {
		try {
			m.rmiStub.usrLeaves(u);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void UpdateUsrStatusToSever(Usr u) {
		try {
			m.rmiStub.usrUpdateStatus(u);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void UpdateUsrEditingStatusToSever(Usr u) {
		try {
			m.rmiStub.usrUpdateEditingStatus(u);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void UpdateInfoFromSever() {
		Vector<Usr> usrList = new Vector<Usr>();
		ChattingHistory h = new ChattingHistory();
		String topic = new String();
	    try {
			usrList = this.m.rmiStub.usrRetriveUsersList();
			h = this.m.rmiStub.usrRetriveChattingHistory();
			topic = this.m.rmiStub.usrRetriveTopic();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.m.m.usrList = usrList;
	    this.m.h.chattingHistory = h.chattingHistory;
	    if (!this.m.capturingTopicInput && !topic.equals(this.m.topic)) {
	    	this.m.topicChanges = true;
	    	this.m.topic = topic;
	    }
	    
	}
	
	protected void UpdateTopicToSever(String topic) {
		try {
			m.rmiStub.usrUpdateTopic(topic);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
