package com.gobananas.android.moneyanalyser.login;


import com.gobananas.android.moneyanalyser.R;
import com.gobananas.android.moneyanalyser.dashboard.DashboardScreen;
import com.gobananas.android.moneyanalyser.lib.ApplicationConstants;
import com.gobananas.android.moneyanalyser.lib.BackendUtils;
import com.gobananas.android.moneyanalyser.lib.Preferences;
import com.gobananas.android.moneyanalyser.registration.RegistrationScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends Activity implements OnClickListener{
	private String username, password;
	private Preferences pref;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		pref = new Preferences(getApplicationContext());
		setContentView(R.layout.loginscreen);
		Button okButton = (Button)findViewById(R.id.okbtn);
		okButton.setOnClickListener(this);
		Button cancelButton = (Button)findViewById(R.id.cancelbtn);
		cancelButton.setOnClickListener(this);
		Button registrationButton = (Button)findViewById(R.id.newregistration);
		registrationButton.setOnClickListener(this);
	}
	private void pullValuesFromFields(){
		EditText loginID = (EditText)findViewById(R.id.loginID);
		username = loginID.getText().toString();
		EditText passwordField = (EditText)findViewById(R.id.password);
		password = passwordField.getText().toString();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.okbtn:
			pullValuesFromFields();
			if(username==null || username.length() == 0){
				Toast.makeText(getApplicationContext(), "Please enter User ID", 4000).show();
			}
			else if(password==null || password.length() == 0){
				Toast.makeText(getApplicationContext(), "Please enter password", 4000).show();
			}else{
				BackendUtils.getInstance().login(username, password);
				loginSuccess();
			}
			Log.d("LoginScreen", "OK pressed: username: "+username+", password: "+password);
			
			break;
		case R.id.cancelbtn:
			Log.d("LoginScreen", "Cancel pressed");
			finish();
			break;
		case R.id.newregistration:
			Intent registrationIntent = new Intent(getApplicationContext(), RegistrationScreen.class);
	    	this.startActivity(registrationIntent);
			finish();
			break;
		}
	}
	public void loginSuccess(){
		pref.setBooleanValue(ApplicationConstants.USER_LOGGED_IN, true);
		pref.setStringValue(ApplicationConstants.USER_NAME, username);
		Intent dashboardIntent = new Intent(getApplicationContext(), DashboardScreen.class);
    	this.startActivity(dashboardIntent);
    	finish();
	}
	
}
