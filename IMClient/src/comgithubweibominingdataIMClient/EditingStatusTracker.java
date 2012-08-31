package comgithubweibominingdataIMClient;

import java.util.Date;

public class EditingStatusTracker {
	private Date lastKeyTypedTime = new Date();

	public EditingStatusTracker() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getEditingStatus(Date ctime, int txtSize) {
		if (txtSize==0) {
			return "NotEntered";
		}
		else{
			if (Math.abs(ctime.getTime()-lastKeyTypedTime.getTime())/1000 < 5) {
				return "ActivelyEditing";
			}
			else {
				return "NotActivelyEditing";
			}
		}
	}

	public Date getLastKeyTypedTime() {
		return lastKeyTypedTime;
	}

	public void setLastKeyTypedTime(Date lastKeyTypedTime) {
		this.lastKeyTypedTime = lastKeyTypedTime;
	}

}
