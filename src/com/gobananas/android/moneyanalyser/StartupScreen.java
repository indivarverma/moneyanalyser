package com.gobananas.android.moneyanalyser;

import com.gobananas.android.moneyanalyser.dashboard.DashboardScreen;
import com.gobananas.android.moneyanalyser.lib.ApplicationConstants;
import com.gobananas.android.moneyanalyser.lib.Preferences;
import com.gobananas.android.moneyanalyser.login.LoginScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartupScreen extends Activity {
	private Preferences pref;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = new Preferences(getApplicationContext());
               
    }
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	
        if(pref.getBooleanValue(ApplicationConstants.USER_LOGGED_IN)){
        	Intent dashboardIntent = new Intent(getApplicationContext(), DashboardScreen.class);
        	this.startActivity(dashboardIntent);
        	finish();
        }else{
        	Intent loginScreenIntent = new Intent(getApplicationContext(), LoginScreen.class);
        	this.startActivity(loginScreenIntent);
        	finish();
        }
    }
}