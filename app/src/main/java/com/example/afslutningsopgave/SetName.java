package com.example.afslutningsopgave;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SetName extends AppCompatActivity implements View.OnClickListener {
    TextView txtName;
    RadioGroup rgNameOf;
    Button btnSendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);
        txtName = findViewById(R.id.setName);
        rgNameOf = findViewById(R.id.rgNameOf);
        btnSendName = findViewById(R.id.btnSetName);
        btnSendName.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int rbId = rgNameOf.getCheckedRadioButtonId();
        if (rbId == -1){
            return;
        }

        RadioButton rbGetName = findViewById(rbId);
        String setName = rbGetName.getText().toString();
        String message = setName +": "+txtName.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("nameOf", message);
        setResult(RESULT_OK, intent);
        finish();
    }
}