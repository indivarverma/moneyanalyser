package com.gobananas.android.moneyanalyser.contacts;

import com.gobananas.android.moneyanalyser.R;

import android.app.Activity;
import android.os.Bundle;

public class ContactActivity extends Activity{
	private TwoWayTabControl tabcontrol;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		tabcontrol = (TwoWayTabControl)findViewById(R.id.tabcontrol);
		tabcontrol.setLeftText("Friends");
		tabcontrol.setRightText("Groups");
	}
}
