package com.example.app;

import android.os.Bundle;
import android.app.Activity;
//import android.app.AlertDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.location.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView textview1 = (TextView) findViewById(R.id.textView1);
				TextView textview2 = (TextView) findViewById(R.id.textView2);
				LocationManager locman = null;
				LocationListener loclis;

				locman = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				loclis = new MyLocationListener();
				locman.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
						0, loclis);

				// check that the >GPS is on!
				if (locman.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					if (MyLocationListener.latitude > 0) {
						textview1.append("Latitude is atm: "
								+ MyLocationListener.latitude + "\n");
						textview2.append("Longtitude is atm: "
								+ MyLocationListener.longtitude + "\n");
					} else {
						// AlertDialog alert = new AlertDialog(null);
						// alert.setTitle("Wait");

					}

				} else {
					textview1.setText("GPS is off!");
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
