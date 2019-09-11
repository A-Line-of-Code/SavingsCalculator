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
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setdate);

        mCalendarView = findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                date = i2 + "-"+ (i1+1) + "-"+ i;
                Toast.makeText(
                        SetDateActivity.this, "Starts Saving on: "
                        + date , Toast.LENGTH_SHORT).show();
            }
        });

        btnFinishDate = findViewById(R.id.btnFinishDate);
        btnFinishDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weeks = getIntent().getExtras().getInt("weeks");
                days = weeks * 7;
                CalculateDate c2 = new CalculateDate(date, days);
                String finishDate = c2.calculateFinDate(date,days);

                Toast.makeText(
                        SetDateActivity.this, "Finishes Saving on: "
                                + finishDate , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
