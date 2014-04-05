package com.hereshem.arduino;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClickFeature (View v){
        switch (v.getId()) {
          case R.id.btn_forward:
        	  startActivity(new Intent(getApplicationContext(), RobotActivity.class));
        	  break;
          case R.id.btn_reverse:
        	  startActivity(new Intent(getApplicationContext(), RobotWithResponseActivity.class));
              break;
          default: 
        	  break;
        }
    }
}
