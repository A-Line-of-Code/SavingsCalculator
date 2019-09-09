package com.example.savingscalculator;

//import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SetDateActivity extends AppCompatActivity {

    private Button btnFinishDate;
    private CalendarView mCalendarView;
    private int weeks, days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setdate);

        btnFinishDate = findViewById(R.id.btnFinishDate);
        mCalendarView = findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "-"+ (i1+1) + "-"+ i;
                int weeks = getIntent().getExtras().getInt("weeks");
                days = weeks * 7;
                Calculate2 c2 = new Calculate2(date, days);
                Toast.makeText(
                        SetDateActivity.this, "Saving Finish Date: "
                        + c2 , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
