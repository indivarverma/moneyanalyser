package com.gobananas.android.moneyanalyser.lib;

import java.util.List;

public class BackendUtils {
	private static BackendUtils instance;
	public static BackendUtils getInstance(){
		if(instance == null)
			instance = new BackendUtils();
		return instance;
	}
	public void login(String _userName, String _password){
		
	}
	public void getUserInfo(String _userID){
		
	}
	public void updateUserInfo(UserInfo _userInfo){
		
	}
	public void reportTransaction(Transaction _transaction){
		
	}
	public void registerNewUser(String _userID, String _userName, String _password, String _email, String _phonenumber){
		
	}
	public List findGroupForUserID(String _userID){
		return null;
	}
	public List findContactsForUserID(String _userID){
		return null;
	}
}
