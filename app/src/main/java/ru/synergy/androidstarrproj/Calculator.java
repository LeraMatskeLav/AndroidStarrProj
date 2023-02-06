package ru.synergy.androidstarrproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I'm on create, and I'm started");
        setContentView(R.layout.activity_calculator);


        final Button calculate = (Button) findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag,"Button have been pushed");
                calculateAnswe();
            }
        });

    }

    private void calculateAnswe() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal3);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal4);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiple = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All view have been founded");

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        Log.d(LogcatTag, "Successfully grabbed data from input fields");
        Log.d(LogcatTag, "numone is: " + numOne +" ; "+" numtwo is: " + numtwo);

        float solution = 0;

        if (add.isChecked()){
            Log.d(LogcatTag, "Operation is add");
            solution = numone + numtwo;
        }
        if (sub.isChecked()) {
            Log.d(LogcatTag, "Operation is sub");
            solution = numone - numtwo;
        }
        if (multiple.isChecked()) {
            Log.d(LogcatTag, "Operation is multiple");
            solution = numone * numtwo;
        }
        if (divide.isChecked()) {
            Log.d(LogcatTag, "Operation is divide");
            if (numtwo == -1 ){
                Toast.makeText(this, "Number two Cannot be zero", Toast.LENGTH_SHORT).show();
                return;
        }
        solution = numone / numtwo;
        }

        Log.d(LogcatTag, "The result of operation is: " + solution);

        // Log.wtf() // what a terrible failure == error

        answer.setText("The answer is "+ solution);


        











    }


}