package com.hereshem.arduino;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hereshem.arduinolib.RobotController;

public class RobotActivity extends Activity {

	String BASE_URL = "http://192.168.0.226";
	String pin = "123456";
	RobotController robot;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);
		robot = new RobotController();
		robot.setBaseUrl(BASE_URL);
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
			robot.moveForward();
			toast("Forward");
			break;
		case R.id.btn_reverse:
			robot.moveReverse();
			toast("Reverse");
			break;
		case R.id.btn_right:
			robot.moveRight();
			toast("Right");
			break;
		case R.id.btn_left:
			robot.moveLeft();
			toast("Left");
			break;
		default:
			break;
		}
	}

	public void toast(String string) {
		Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT)
				.show();
	}
}