package comgithubweibominingdataIMClient;

import java.util.Vector;

public class UsersManager {
	
	protected Usr currentUsr = new Usr();
	protected Vector<Usr> usrList = new Vector<Usr>();

	public UsersManager() {
		// TODO Auto-generated constructor stub
		this.InitUsrs();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	protected void InitUsrs() {
		this.currentUsr.setUsrName("Alice");
		this.currentUsr.setUsrEditingStatus(UsrEditingStatus.NotEntered);
		this.currentUsr.setUsrStatus(UsrStatus.Available);
		this.currentUsr.setUsrID(0);
		
	}
	
	protected void UpdateUsrs() {

	}

}
