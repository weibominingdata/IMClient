package comgithubweibominingdataIMClient;

import java.io.Serializable;
import java.util.Vector;

public class ChattingHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1853957400403786927L;
	protected Vector<String> chattingHistory = new Vector<String>();
	
	public ChattingHistory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void addAChat(String a){
		chattingHistory.add(a);
	}
	
	public void setChattingHistory(Vector<String> a) {
		chattingHistory = a;
	}
	
	public Vector<String> getChattingHistory() {
		return chattingHistory;
	}

}
