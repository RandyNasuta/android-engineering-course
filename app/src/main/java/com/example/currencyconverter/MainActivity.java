package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertFunction(View view){
        EditText editText = (EditText) findViewById(R.id.editTextNumber);

        String userMoney = editText.getText().toString();
        double amountOfMoney = Double.parseDouble(userMoney) * 1.3;
        String moneyConvert = String.format("%.2f", amountOfMoney);

        Toast.makeText(this, "$" + userMoney + " is " + moneyConvert, Toast.LENGTH_SHORT).show();
        Log.i("msg", "button pressed");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}