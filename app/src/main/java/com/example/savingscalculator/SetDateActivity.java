package com.example.savingscalculator;

//import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SetDateActivity extends AppCompatActivity {

    //private Button btnFinishDate;
    private CalendarView mCalendarView;
    //private int weeks, days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setdate);

       // btnFinishDate = findViewById(R.id.btnFinishDate);
        mCalendarView = findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1+1) + "/"+ i2 + "/" + i;
                Toast.makeText(
                        SetDateActivity.this, "onSelectedDayChange: mm/dd/yyyy: "
                        + date, Toast.LENGTH_SHORT).show();
            }
        });


        /*btnFinishDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                weeks = 100;
                days = weeks*7;



            Toast.makeText(
                    SetDateActivity.this, "It will take", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
