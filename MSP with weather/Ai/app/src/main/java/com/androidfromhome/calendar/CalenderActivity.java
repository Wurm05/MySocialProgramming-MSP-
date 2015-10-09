package com.androidfromhome.calendar;

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
import android.widget.TextView;


import com.androidfromhome.calendar.adapter.CalendarAdapter;
import com.androidfromhome.calendar.util.CalendarCollection;

public class CalenderActivity extends Activity implements OnClickListener {
	public GregorianCalendar cal_month, cal_month_copy;
	private CalendarAdapter cal_adapter;
	private TextView tv_month;
	private Button btn_weather;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calender);

		btn_weather = (Button) findViewById(R.id.btn_weather);
		btn_weather.setOnClickListener(this);

		cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
		cal_month_copy = (GregorianCalendar) cal_month.clone();
		cal_adapter = new CalendarAdapter(this, cal_month,CalendarCollection.date_collection_arr);
		
		
		
		tv_month = (TextView) findViewById(R.id.tv_month);
		tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));

		ImageButton previous = (ImageButton) findViewById(R.id.ib_prev);

		previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setPreviousMonth();
				refreshCalendar();
			}
		});

		ImageButton next = (ImageButton) findViewById(R.id.Ib_next);
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setNextMonth();
				refreshCalendar();

			}
		});


		GridView gridview = (GridView) findViewById(R.id.gv_calendar);
		gridview.setAdapter(cal_adapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
			
				((CalendarAdapter) parent.getAdapter()).setSelected(v,position);
				String selectedGridDate = CalendarAdapter.day_string
						.get(position);
				
				String[] separatedTime = selectedGridDate.split("-");
				String gridvalueString = separatedTime[2].replaceFirst("^0*","");
				int gridvalue = Integer.parseInt(gridvalueString);

				if ((gridvalue > 10) && (position < 8)) {
					setPreviousMonth();
					refreshCalendar();
				} else if ((gridvalue < 7) && (position > 28)) {
					setNextMonth();
					refreshCalendar();
				}
				((CalendarAdapter) parent.getAdapter()).setSelected(v,position);


				((CalendarAdapter) parent.getAdapter()).getPositionList(selectedGridDate, CalenderActivity.this);
			}
			
		});
	


	}
	
	
	protected void setNextMonth() {
		if (cal_month.get(GregorianCalendar.MONTH) == cal_month
				.getActualMaximum(GregorianCalendar.MONTH)) {
			cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1),
					cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
		} else {
			cal_month.set(GregorianCalendar.MONTH,
					cal_month.get(GregorianCalendar.MONTH) + 1);
		}

	}

	protected void setPreviousMonth() {
		if (cal_month.get(GregorianCalendar.MONTH) == cal_month
				.getActualMinimum(GregorianCalendar.MONTH)) {
			cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1),
					cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
		} else {
			cal_month.set(GregorianCalendar.MONTH,
					cal_month.get(GregorianCalendar.MONTH) - 1);
		}

	}

	public void refreshCalendar() {
		cal_adapter.refreshDays();
		cal_adapter.notifyDataSetChanged();
		tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_weather:
				startActivity(new Intent(CalenderActivity.this,WeatherActivity.class));

				break;

			default:
				break;
		}
	}
}
