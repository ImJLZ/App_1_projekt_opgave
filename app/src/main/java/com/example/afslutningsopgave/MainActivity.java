package com.example.afslutningsopgave;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnToColor, btnToName;
    TextView txtName;
    View vColor;
    ActivityResultLauncher<Intent> launcher, launcherColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        vColor = findViewById(R.id.vColor);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent i = result.getData();
                    String s =i.getStringExtra("nameOf");
                    txtName.setText(s);
                }
        );
        launcherColor = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent i = result.getData();
                    int color = i.getIntExtra("color",0);
                    vColor.setBackgroundColor(color);
                }
        );

        btnToName = findViewById(R.id.btnToName);
        btnToColor = findViewById(R.id.btnToColor);

        btnToName.setOnClickListener(v -> {
            Intent intentToSetName = new Intent(MainActivity.this, SetName.class);
            launcher.launch(intentToSetName);
        });
        btnToColor.setOnClickListener(v -> {
            Intent intentToSetColor = new Intent(MainActivity.this, SetColor.class);
            launcherColor.launch(intentToSetColor);
        });
    }
}