package com.gobananas.android.moneyanalyser.lib;

import java.util.Vector;

public class Transaction {
	private Vector<UserAmountPair> spenders;
	private Vector<UserAmountPair> participants;
	private int transaction_amount;
	private String comments;
	

	public Transaction(){
		spenders = new Vector<UserAmountPair>();
		participants = new Vector<UserAmountPair>();
	}
	
	public Vector<UserAmountPair> getSpenders() {
		return spenders;
	}
	public void addSpender(String _spender, int _amount){
		spenders.add(new UserAmountPair(_spender, _amount));
	}
	public Vector<UserAmountPair> getParticipants() {
		return participants;
	}
	public void addParticipant(String _spender, int _amount){
		participants.add(new UserAmountPair(_spender, _amount));
	}
	public int getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(int transactionAmount) {
		transaction_amount = transactionAmount;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	class UserAmountPair{
		private String userID;
		private int amount;
		public UserAmountPair(String _userID, int _amount) {
			// TODO Auto-generated constructor stub
			userID = _userID;
			amount = _amount;
		}
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
	}
}
