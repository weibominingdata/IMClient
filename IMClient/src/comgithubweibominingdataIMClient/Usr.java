package comgithubweibominingdataIMClient;

import java.io.Serializable;

public class Usr implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9219021033883245202L;
	private String usrName;
	private UsrStatus usrStatus;
	private UsrEditingStatus usrEditingStatus;
	private int UsrID = -1;

	public Usr() {
		// TODO Auto-generated constructor stub
		setUsrStatus(UsrStatus.Available);
		setUsrEditingStatus(UsrEditingStatus.NotEntered);		
	}
	
	public Usr(String name) {
		setUsrName(name);
		setUsrStatus(UsrStatus.Available);
		setUsrEditingStatus(UsrEditingStatus.NotEntered);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public UsrStatus getUsrStatus() {
		return usrStatus;
	}

	public void setUsrStatus(UsrStatus usrStatus) {
			this.usrStatus = usrStatus;
	}

	public UsrEditingStatus getUsrEditingStatus() {
		return usrEditingStatus;
	}

	public boolean setUsrEditingStatus(UsrEditingStatus usrEditingStatus) {
		// return value: changed status?
		if (usrEditingStatus == this.usrEditingStatus) {
			return false;
		}
		else {
			this.usrEditingStatus = usrEditingStatus;
			return true;
		}
	}

	public int getUsrID() {
		return UsrID;
	}

	public void setUsrID(int usrID) {
		UsrID = usrID;
	}
	
	protected void setUsrStatusString(String s){
		if (s.equalsIgnoreCase("Available")){
			this.usrStatus=UsrStatus.Available;
		} else if (s.equalsIgnoreCase("Busy")){
			this.usrStatus=UsrStatus.Busy;
		} else if (s.equalsIgnoreCase("Idle")) {
			this.usrStatus=UsrStatus.Idle;
		} else {
			this.usrStatus=UsrStatus.Available;
		}
	}
	
	protected void setUsrEditingStatusString(String s){
		if (s.equalsIgnoreCase("NotEntered")){
			this.usrEditingStatus=UsrEditingStatus.NotEntered;
		} else if (s.equalsIgnoreCase("ActivelyEditing")){
			this.usrEditingStatus=UsrEditingStatus.ActivelyEditing;
		} else if (s.equalsIgnoreCase("NotActivelyEditing")) {
			this.usrEditingStatus=UsrEditingStatus.NotActivelyEditing;
		} else {
			this.usrEditingStatus=UsrEditingStatus.NotEntered;
		}
	}
	
	protected static String getUsrStatusString(UsrStatus s){
		if (s==UsrStatus.Available){
			return "Available";
		} else if (s==UsrStatus.Busy){
			return "Busy";
		} else if (s==UsrStatus.Idle) {
			return "Idle";
		} else {
			return "Available";
		}
	}

	protected static String getUsrEditStatusString(UsrEditingStatus s){
		if (s==UsrEditingStatus.NotEntered){
			return "NotEntered";
		} else if (s==UsrEditingStatus.ActivelyEditing){
			return "ActivelyEditing";
		} else if (s==UsrEditingStatus.NotActivelyEditing) {
			return "NotActivelyEditing";
		} else {
			return "NotEntered";
		}
	}
	
	public String toString() {
		return "("+ Usr.getUsrStatusString(this.getUsrStatus()).charAt(0)+ ")"+ this.getUsrName() + ":"+ Usr.getUsrEditStatusString(this.getUsrEditingStatus()) + "\n";
	}

}
