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
	
	public UsrEditingStatus getEditingStatus(Date ctime, int txtSize) {
		if (txtSize==0) {
			return UsrEditingStatus.NotEntered;
		}
		else{
			if (Math.abs(ctime.getTime()-lastKeyTypedTime.getTime())/1000 < 5) {
				return UsrEditingStatus.ActivelyEditing;
			}
			else {
				return UsrEditingStatus.NotActivelyEditing;
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
