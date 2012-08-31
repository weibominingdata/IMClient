package comgithubweibominingdataIMClient;

public class Usr {
	private String usrName;
	private UsrStatus usrStatus;
	private UsrEditingStatus usrEditingStatus;
	private int UsrID;

	public Usr() {
		// TODO Auto-generated constructor stub
		
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

	public void setUsrEditingStatus(UsrEditingStatus usrEditingStatus) {
			this.usrEditingStatus = usrEditingStatus;
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

}
