package com.hereshem.arduino;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClickFeature (View v){
        switch (v.getId()) {
          case R.id.btn_rob:
        	  startActivity(new Intent(getApplicationContext(), RobotActivity.class));
        	  break;
          case R.id.btn_robres:
        	  startActivity(new Intent(getApplicationContext(), RobotWithResponseActivity.class));
              break;
          case R.id.btn_cus:
        	  startActivity(new Intent(getApplicationContext(), CustomRobotActivity.class));
              break;
          default: 
        	  break;
        }
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
