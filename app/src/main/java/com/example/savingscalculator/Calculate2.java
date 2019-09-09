package com.example.savingscalculator;
import java.text.*;
import java.util.*;

public class Calculate2 {

    String date;
    int days;

    public Calculate2(String date, int days){
        this.date=date;
        this.days=days;
    }
        
    public String calculateFinDate(String date, int days) {
        String startDate = date;

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Calendar c = Calendar.getInstance(); // Get Calendar Instance
        try {
            c.setTime(sdf.parse(startDate));
            c.add(Calendar.DATE, (days - 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date resultdate = new Date(c.getTimeInMillis());
        String finishDate = sdf.format(resultdate);
        System.out.println("finishDate:"+finishDate);
        return finishDate;
    }

}
