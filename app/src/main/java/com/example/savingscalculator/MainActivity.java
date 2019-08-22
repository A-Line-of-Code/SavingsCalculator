package com.example.savingscalculator;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;
    private EditText editTextWeeklyIncome, editTextExpenditure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        editTextWeeklyIncome = findViewById(R.id.editTextWeeklyIncome);
        editTextExpenditure = findViewById(R.id.editTextExpenditure);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Income minus Expenditure is " + subtract(), Toast.LENGTH_SHORT).show();
            }
        });
    } // end of onCreate() method

    public int subtract() {
        int weeklyIncome = Integer.parseInt(editTextWeeklyIncome.getText().toString());
        int expenditure = Integer.parseInt(editTextExpenditure.getText().toString());
        int result = weeklyIncome - expenditure;
        return result;
    } // end of subtract() method
}
