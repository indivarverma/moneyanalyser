package com.gobananas.android.moneyanalyser.registration;


import com.gobananas.android.moneyanalyser.R;
import com.gobananas.android.moneyanalyser.dashboard.DashboardScreen;
import com.gobananas.android.moneyanalyser.lib.ApplicationConstants;
import com.gobananas.android.moneyanalyser.lib.BackendUtils;
import com.gobananas.android.moneyanalyser.lib.Preferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationScreen extends Activity implements OnClickListener{
	private Preferences pref;
	private Button okbutton;
	private Button cancelbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		pref = new Preferences(getApplicationContext());
		setContentView(R.layout.registration);
		okbutton = (Button)findViewById(R.id.okbutton);
		okbutton.setOnClickListener(this);
		cancelbutton = (Button)findViewById(R.id.cancelbutton);
		cancelbutton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.okbutton:
			finish();
			EditText userIDField = (EditText)findViewById(R.id.loginID);
			EditText passwordField = (EditText)findViewById(R.id.password);
			EditText fullnameIDField = (EditText)findViewById(R.id.fullname);
			EditText emailIDField = (EditText)findViewById(R.id.emailID);
			EditText phonenumberField = (EditText)findViewById(R.id.phonenumber);
			BackendUtils.getInstance().registerNewUser(userIDField.getText().toString(), fullnameIDField.getText().toString(), passwordField.getText().toString(), emailIDField.getText().toString(), phonenumberField.getText().toString());
			break;
		case R.id.cancelbutton:
			finish();
			break;
		
		}
	}
	
}
