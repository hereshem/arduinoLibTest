package com.hereshem.arduino;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.hereshem.arduinolib.RobotController;

public class RobotActivity extends Activity {

	RobotController robot;
	TextView res;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);

		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		String url = preferences.getString("preIp", "http://192.168.11.177");
		String pin = preferences.getString("prePin", "1234");
		
		res = (TextView) findViewById(R.id.txt_response);
		
		robot = new RobotController();
		robot.setBaseUrl(url);
		robot.setPin(pin);
		
		if(!robot.isNetworkConnected(getApplicationContext())){
			toast("No internet connection");
		}
	}

	/*
	 * This function is triggered by setting onclick value for the view in layout 
	 * */
	public void onClickFeature(View v) {

		switch (v.getId()) {
			case R.id.btn_forward:
				//robot.moveForward();
				robot.moveCommand("=1");
				toast("Forward");
				break;
			case R.id.btn_reverse:
				//robot.moveReverse();
				robot.moveCommand("=2");
				toast("Reverse");
				break;
			case R.id.btn_right:
				//robot.moveRight();
				robot.moveCommand("=3");
				toast("Right");
				break;
			case R.id.btn_left:
				//robot.moveLeft();
				robot.moveCommand("=4");
				toast("Left");
				break;
			case R.id.btn_stop:
				//robot.moveLeft();
				robot.moveCommand("=0");
				toast("Stop");
				break;
			default:
				break;
		}
	}

	public void toast(String string) {
		//Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
		res.setText("Command = " + string);
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
