package com.example.savingscalculator;
import android.util.Log;

import java.text.*;
import java.util.*;

public class Calculate2 {

    private String date;
    private int days;

    Calculate2(String date, int days){
        this.date=date;
        this.days=days;
    }

    String calculateFinDate(String date, int days) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Calendar c = Calendar.getInstance(); // Get Calendar Instance

            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, (days - 1));

            sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date resultdate = new Date(c.getTimeInMillis());
            String finishDate = sdf.format(resultdate);
            Log.d("finishDate","finishDate: "+ finishDate);
            return finishDate;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
