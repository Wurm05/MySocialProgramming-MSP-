package com.androidfromhome.calendar;

import java.text.DateFormat;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;



public class ListViewActivity extends Activity implements OnClickListener {

	private ListView lv_android;
	private AndroidListAdapter list_adapter;
	private Button btn_calender;
	private Button 	btn_addEvent;
	private Button 	btn_update;
	DatePicker datePicker;
	EditText mEdit;
	int day;
	int month;
	int year;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		CalendarCollection.date_collection_arr=new ArrayList<CalendarCollection>();

		CalendarCollection.date_collection_arr.add(new CalendarCollection("2015-04-01", "John Birthday"));


		getWidget();

	}


	
	public void getWidget(){
		mEdit   = (EditText)findViewById(R.id.event);


		btn_calender = (Button) findViewById(R.id.btn_calender);
		btn_calender.setOnClickListener(this);


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

		case R.id.update:
			datePicker = (DatePicker) findViewById(R.id.datePicker2);
			day = datePicker.getDayOfMonth();
			month = datePicker.getMonth();
			year = datePicker.getYear();
			CalendarCollection.date_collection_arr.add(new CalendarCollection(""+year+"-"+month+"-"+day+"", mEdit.getText().toString()));
			getWidget();
			break;


		default:
			break;
		}
		
	}
	
}
