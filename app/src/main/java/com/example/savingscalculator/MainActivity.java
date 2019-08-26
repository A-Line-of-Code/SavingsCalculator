package com.example.savingscalculator;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.savingscalculator.Calculate.*;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate, btnHelp;
    private EditText editTextGoal, editTextWeeklyIncome, editTextExpenditure, editTextPercentage;
    private double goal, income, tax, expenditure, percentage, net, result, weeks;
    private String currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnHelp = findViewById(R.id.btnHelp);
        editTextGoal = findViewById(R.id.editTextGoal);
        editTextWeeklyIncome = findViewById(R.id.editTextWeeklyIncome);
        editTextExpenditure = findViewById(R.id.editTextExpenditure);
        editTextPercentage = findViewById(R.id.editTextPercentage);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goal = Double.parseDouble(editTextGoal.getText().toString());
                currency = editTextWeeklyIncome.getText().toString();
                goal = calculateCurrency(currency, goal);

                income = Double.parseDouble(editTextWeeklyIncome.getText().toString());
                tax = calculateTax(income);

                expenditure = Double.parseDouble(editTextExpenditure.getText().toString());
                percentage = Double.parseDouble(editTextPercentage.getText().toString());

                net = calculateNet(income, tax);
                result = calculateGoal(net, expenditure, percentage);
                weeks = calculateWeeks(goal, result);

                Toast.makeText(MainActivity.this, "It will take " + Math.round(weeks) + " weeks to save $" + Math.round(goal), Toast.LENGTH_SHORT).show();
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
