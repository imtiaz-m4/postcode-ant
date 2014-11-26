package com.metafour.postcode;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Result extends Activity {
	private static final String BASE_URI = "http://postcode.geom4.net";
	private static final String CUSTOMER = "100001";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
		PostcodeSearchRS rs = PostcodeClient.getInstance(BASE_URI).search(CUSTOMER, getIntent().getStringExtra("com.metafour.postcode.POSTALCODES"));
		List<String> addresses = null;
		if (rs.isOK()) {
			addresses = new ArrayList<String>(rs.getAddress().size());
			for (Address it : rs.getAddress()) {
				addresses.add(it.getAddressLine1());
			}
		} else {
			addresses = new ArrayList<String>(1);
			addresses.add(rs.getStatus().getValue());
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_row, R.id.address_item, addresses);
		ListView listview = (ListView) findViewById(R.id.listView);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
