package com.hereshem.arduino;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hereshem.arduinolib.RobotControllerWithResopnse;
import com.hereshem.arduinolib.RobotControllerWithResopnse.CallNetwork;

public class CustomRobotActivity extends Activity implements CallNetwork {

	RobotControllerWithResopnse robot;
	EditText edtext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom);

		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		String url = preferences.getString("preIp", "http://192.168.11.177");
		String pin = preferences.getString("prePin", "1234");

		edtext = (EditText) findViewById(R.id.ed_url);
		((TextView) findViewById(R.id.txt_url)).setText(url + "/" + pin + "/ ");
		robot = new RobotControllerWithResopnse(this);
		robot.setBaseUrl(url);
		robot.setPin(pin);

		if (!robot.isNetworkConnected(getApplicationContext())) {
			toast("No internet connection");
		}
	}

	/*
	 * This function is triggered by setting onclick value for the view in
	 * layout
	 */
	public void onClickFeature(View v) {
		String data = edtext.getText().toString();
		robot.moveCommand(data);
		toast("Sending " + data);
	}

	public void toast(String string) {
		Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void onResultNetwork(String command, String result) {
		TextView txt = (TextView) findViewById(R.id.txt_response);
		txt.setText("Command = " + command + "\n\nResponse = \n" + result);
	}

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	startActivity(new Intent(getApplicationContext(), SettingActivity.class));
    	return true;
    }

}
