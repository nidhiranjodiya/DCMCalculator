package com.pcs.dcmcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SinCalculator extends AppCompatActivity {

    EditText edtHeight, edtLength, edtDegree, edtMinute, edtSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_calculator2);

        edtHeight = findViewById(R.id.edtHeight);
        edtLength = findViewById(R.id.edtLength);
        edtDegree = findViewById(R.id.edtDegree);
        edtMinute = findViewById(R.id.edtMinute);
        edtSecond = findViewById(R.id.edtSecond);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.omenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuCalc:
                startActivity(new Intent(this, MainActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnClickCalculateHeight(View view) {
        //String valHeight = edtHeight.getText().toString();
        DecimalFormat df = new DecimalFormat("0.000");
        df.setRoundingMode(RoundingMode.CEILING);

        double valLength = getDoubleVal(edtLength.getText().toString());
        double valDegree = getDoubleVal(edtDegree.getText().toString());
        double valMinute = getDoubleVal(edtMinute.getText().toString());
        double valSecond = getDoubleVal(edtSecond.getText().toString());

        double radianVal = (Math.PI * (valDegree + (valMinute / 60) + (valSecond / 3600))) / 180;
        double height = Math.sin(radianVal) * valLength;

        edtHeight.setText(df.format(height));
    }

    private double getDoubleVal(String s) {
        if (s.trim().equals("")) return 0.0;
        else return Double.parseDouble(s);
    }
}