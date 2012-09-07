package comgithubweibominingdataIMClient;

import java.io.Serializable;
import java.util.Vector;

public class UsersManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705845415148073581L;
	public Usr currentUsr = new Usr();
	public Vector<Usr> usrList = new Vector<Usr>();

	public UsersManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	protected void InitUsrs(Usr u) {
		this.currentUsr.setUsrName(u.getUsrName());
		this.currentUsr.setUsrEditingStatus(UsrEditingStatus.NotEntered);
		this.currentUsr.setUsrStatus(UsrStatus.Available);
		this.currentUsr.setUsrID(u.getUsrID());
		
	}
	
	protected void UpdateUsrs() {

	}

}
