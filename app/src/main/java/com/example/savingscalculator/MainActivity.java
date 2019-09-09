package com.example.savingscalculator;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate, btnHelp;
    private EditText editTextGoal, editTextWeeklyIncome, editTextExpenditure, editTextPercentage;
    private Spinner dropdownCurrencies;

    private double goal, income, expenditure, rateOfSaving;
    private double goalWithCurrency, incomeAfterTax, savings;
    private int weeks;
    private String currency;
    private Button btnGoCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGoal = findViewById(R.id.editTextGoal);
        editTextWeeklyIncome = findViewById(R.id.editTextWeeklyIncome);
        editTextExpenditure = findViewById(R.id.editTextExpenditure);
        editTextPercentage = findViewById(R.id.editTextPercentage);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);

        dropdownCurrencies = findViewById(R.id.spinnerCurrency);
        final String[] currencies = new String[]{"NZD","USD","AUD","EUR","GBP"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, currencies);
        dropdownCurrencies.setAdapter(adapter);

        btnHelp = findViewById(R.id.btnHelp);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            goal = Double.parseDouble(editTextGoal.getText().toString());
            income = Double.parseDouble(editTextWeeklyIncome.getText().toString());
            expenditure = Double.parseDouble(editTextExpenditure.getText().toString());
            rateOfSaving = Double.parseDouble(editTextPercentage.getText().toString());
            currency = String.valueOf(dropdownCurrencies.getSelectedItem());

            Calculate c1 = new Calculate(goal, income, expenditure, rateOfSaving, currency);

            goalWithCurrency = c1.calculateGoalWithCurrency(c1.getGoal(), c1.getCurrency());
            incomeAfterTax = c1.calculateIncomeAfterTax(c1.getIncome());
            savings = c1.calculateSavings(incomeAfterTax, c1.getExpenses(), c1.getRateOfSaving());
            weeks = c1.calculateWeeks(goalWithCurrency, savings);

            Toast.makeText(MainActivity.this, "It will take " + weeks + " weeks to save $" + goal + " (" + currency + ")", Toast.LENGTH_SHORT).show();
            /*added by Skylar 09SEP2019*/
            Intent intent = new Intent(MainActivity.this, SetDateActivity.class);
            intent.putExtra("weeks", weeks);
            startActivity(intent);
                /*added by Skylar 09SEP2019*/
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent help = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(help);
            }
        });

        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SetDateActivity.class);
                startActivity(intent);
            }
        });
    }
}
