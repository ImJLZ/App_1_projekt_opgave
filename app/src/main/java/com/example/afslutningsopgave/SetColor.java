package com.example.afslutningsopgave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SetColor extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private View vColorSetColor, vColor;
    private Spinner spnRed, spnGreen, spnBlue;
    private int colorCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color);
        String[] colorArr = {"00", "10", "20", "30", "40", "50", "60", "70", "80", "90", "A0", "B0", "C0", "D0", "E0", "F0", "FF"};

        vColorSetColor = findViewById(R.id.vColorSetColor);
        vColor = findViewById(R.id.vColor);
        spnRed = findViewById(R.id.spnRed);
        spnGreen = findViewById(R.id.spnGreen);
        spnBlue = findViewById(R.id.spnBlue);
        Button btnSendColor = findViewById(R.id.btnSendColor);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(SetColor.this, android.R.layout.simple_spinner_item, colorArr);

        spnRed.setAdapter(adapter);
        spnGreen.setAdapter(adapter);
        spnBlue.setAdapter(adapter);

        spnRed.setOnItemSelectedListener(this);
        spnGreen.setOnItemSelectedListener(this);
        spnBlue.setOnItemSelectedListener(this);

        btnSendColor.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String colorStr = spnRed.getSelectedItem().toString();
        colorStr += spnGreen.getSelectedItem().toString();
        colorStr += spnBlue.getSelectedItem().toString();

        colorCode = Integer.parseInt(colorStr, 16);
        colorCode += 0xFF000000;

        vColorSetColor.setBackgroundColor(colorCode);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("color", colorCode);
        setResult(RESULT_OK, intent);
        finish();
    }
}