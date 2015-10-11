package com.androidfromhome.calendar;

import java.util.ArrayList;

import com.androidfromhome.calendar.R;
import com.androidfromhome.calendar.adapter.AndroidListAdapter;
import com.androidfromhome.calendar.util.CalendarCollection;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;



public class ListViewActivity extends Activity implements OnClickListener {

	private ListView lv_android;
	private AndroidListAdapter list_adapter;
	private Button btn_calender;
	private Button 	btn_addEvent;
	private Button 	btn_update;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		CalendarCollection.date_collection_arr=new ArrayList<CalendarCollection>();

		CalendarCollection.date_collection_arr.add(new CalendarCollection("2015-04-01","John Birthday"));
		CalendarCollection.date_collection_arr.add(new CalendarCollection("2015-04-01", "Birthday"));



		getWidget();
	}


	
	public void getWidget(){
		btn_calender = (Button) findViewById(R.id.btn_calender);
		btn_calender.setOnClickListener(this);

		btn_addEvent = (Button) findViewById(R.id.button2);
		btn_addEvent.setOnClickListener(this);

		btn_update = (Button) findViewById(R.id.update);
		btn_update.setOnClickListener(this);

		lv_android = (ListView) findViewById(R.id.lv_android);
		list_adapter=new AndroidListAdapter(ListViewActivity.this,R.layout.list_item, CalendarCollection.date_collection_arr);
		lv_android.setAdapter(list_adapter);


	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_calender:
			startActivity(new Intent(ListViewActivity.this, CalenderActivity.class));
			break;
		case R.id.button2:
			startActivity(new Intent(ListViewActivity.this, AddEventActivity.class));
			break;
		case R.id.update:
			CalendarCollection.date_collection_arr.add(new CalendarCollection("2015-04-01", "Birthday"));
			getWidget();
			break;


		default:
			break;
		}
		
	}
	
}
