package com.example.savingscalculator;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate, btnHelp;
    private EditText editTextGoal, editTextWeeklyIncome, editTextExpenditure, editTextPercentage, editTextCurrency;
    private double goal, income, expenditure, rateOfSaving;
    private double goalWithCurrency, incomeAfterTax, savings;
    private int weeks;
    private String currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGoal = findViewById(R.id.editTextGoal);
        editTextWeeklyIncome = findViewById(R.id.editTextWeeklyIncome);
        editTextExpenditure = findViewById(R.id.editTextExpenditure);
        editTextPercentage = findViewById(R.id.editTextPercentage);
        editTextCurrency = findViewById(R.id.editTextCurrency);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnHelp = findViewById(R.id.btnHelp);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goal = Double.parseDouble(editTextGoal.getText().toString());
                income = Double.parseDouble(editTextWeeklyIncome.getText().toString());
                expenditure = Double.parseDouble(editTextExpenditure.getText().toString());
                rateOfSaving = Double.parseDouble(editTextPercentage.getText().toString());
                currency = editTextCurrency.getText().toString();

                Calculate c1 = new Calculate(goal, income, expenditure, rateOfSaving, currency);
//                Toast.makeText(MainActivity.this, "ToString(): " + c1.toString(), Toast.LENGTH_SHORT).show();

                goalWithCurrency = c1.calculateGoalWithCurrency(c1.getGoal(), c1.getCurrency());
                incomeAfterTax = c1.calculateIncomeAfterTax(c1.getIncome());
                savings = c1.calculateSavings(incomeAfterTax, c1.getExpenses(), c1.getRateOfSaving());
                weeks = c1.calculateWeeks(goalWithCurrency, savings);

                Toast.makeText(MainActivity.this, "It will take " + weeks + " weeks to save $" + goal + " (" + currency + ")", Toast.LENGTH_SHORT).show();
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent help = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(help);
            }
        });
    }
}
