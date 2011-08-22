package com.gobananas.android.moneyanalyser.dashboard;

import com.gobananas.android.moneyanalyser.R;
import com.gobananas.android.moneyanalyser.contacts.ContactActivity;
import com.gobananas.android.moneyanalyser.lib.ApplicationConstants;
import com.gobananas.android.moneyanalyser.lib.Preferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DashboardScreen extends Activity implements OnItemClickListener{
	String[] s = new String[]{
			"Status Report", "Report Bill", "Report Payment", "Contacts", "Settings"	
		};
	private Preferences pref;
	private ListView menulist;
	private MyAdapter myAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myAdapter = new MyAdapter();
		pref = new Preferences(getApplicationContext());
		setContentView(R.layout.dashboard);
		menulist = (ListView)findViewById(R.id.menulist);
		menulist.setAdapter(myAdapter);
		menulist.setOnItemClickListener(this);
		TextView userID = (TextView)findViewById(R.id.username);
		userID.setText(pref.getStringValue(ApplicationConstants.USER_NAME));
	}
	class MyAdapter extends BaseAdapter{
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return s.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return s[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.menuitem, null);
			}
			TextView label = (TextView)convertView.findViewById(R.id.label);
			label.setText(s[position]);
			return convertView;
		}
		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.menulist:
			if(arg2 == 3){
				gotoContacts();
			}
			//Toast.makeText(getApplicationContext(), s[arg2],200).show();
			break;
		}
	}
	public void gotoContacts(){
		Intent contactsIntent = new Intent(getApplicationContext(), ContactActivity.class);
    	this.startActivity(contactsIntent);
	}
}
