package com.gobananas.android.moneyanalyser.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;

public class Preferences {
	
	private SharedPreferences sharedPrefs;
	public Preferences(Context context){
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		
	}
	public String getStringValue(String key){
		return sharedPrefs.getString(key, null);
	}
	public void setStringValue(String key, String value){
		Editor editor = sharedPrefs.edit();
		editor.putString(key, value);
		editor.commit();
	}
	public boolean getBooleanValue(String key){
		return sharedPrefs.getBoolean(key, false);
	}
	public void setBooleanValue(String key, boolean value){
		Editor editor = sharedPrefs.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
}
