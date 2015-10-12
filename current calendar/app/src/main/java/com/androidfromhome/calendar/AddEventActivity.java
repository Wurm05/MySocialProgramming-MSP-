package com.androidfromhome.calendar;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.androidfromhome.calendar.adapter.AndroidListAdapter;
import com.androidfromhome.calendar.adapter.CalendarAdapter;
import com.androidfromhome.calendar.util.CalendarCollection;

public class AddEventActivity extends Activity implements OnClickListener{


	private TextView evnt;
	private ListViewActivity event;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addevent);



		evnt = (TextView) findViewById(R.id.event);
		getWidget();

	}


	public void getWidget(){
		btn = (Button) findViewById(R.id.but);
		btn.setOnClickListener(this);



	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.but:
				CalendarCollection.date_collection_arr.add(new CalendarCollection("2013-04-01", "Birthday"));
				startActivity(new Intent(AddEventActivity.this, ListViewActivity.class));
				break;



			default:
				break;
		}

	}
}

