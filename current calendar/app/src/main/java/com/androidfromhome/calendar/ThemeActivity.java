package com.androidfromhome.calendar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ThemeActivity extends Activity implements View.OnClickListener {

    private Button btn_light;
    private Button btn_dark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        btn_light = (Button) findViewById(R.id.light_theme);
        btn_light.setOnClickListener(this);

        btn_dark = (Button) findViewById(R.id.dark_theme);
        btn_dark.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_theme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.light_theme:
                startActivity(new Intent(ThemeActivity.this,CalendarActivityDark.class));
                break;

            case R.id.dark_theme:
                startActivity(new Intent(ThemeActivity.this,CalenderActivity.class));
                break;

            default:
                break;
        }
    }
}
