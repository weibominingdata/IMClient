package comgithubweibominingdataIMClient;

public class Usr {
	private String usrName;
	private String usrStatus;
	private String usrEditingStatus;

	public Usr() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Usr(String name) {
		setUsrName(name);
		setUsrStatus("Available");
		setUsrEditingStatus("NoneEntered");
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

	public String getUsrStatus() {
		return usrStatus;
	}

	public void setUsrStatus(String usrStatus) {
		if (usrStatus.equalsIgnoreCase("Available")  ||
				usrStatus.equalsIgnoreCase("Idle") ||
				usrStatus.equalsIgnoreCase("Busy")) {
			this.usrStatus = usrStatus;
		}
		else {
			this.usrStatus = "Available";
		}
	}

	public String getUsrEditingStatus() {
		return usrEditingStatus;
	}

	public void setUsrEditingStatus(String usrEditingStatus) {
		if (usrEditingStatus.equalsIgnoreCase("NoneEntered")  ||
				usrEditingStatus.equalsIgnoreCase("ActiveTyping") ||
				usrEditingStatus.equalsIgnoreCase("NotActiveTyping")) {
			this.usrEditingStatus = usrEditingStatus;
		}
		else {
			this.usrEditingStatus = "NoneEntered";
		}
	}

}
