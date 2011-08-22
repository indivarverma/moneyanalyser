package com.gobananas.android.moneyanalyser.lib;

import java.util.Vector;

public class UserGroup {
	private int ID;
	private Vector<String> userIDs;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Vector<String> getUserIDs() {
		return userIDs;
	}
	public void setUserIDs(Vector<String> userIDs) {
		this.userIDs = userIDs;
	}
	
}
