package com.example.t5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.t5.R.layout;

public final class MainActivity extends AppCompatActivity {

    public TextView editTextName;
    public Button btnClickMe;
    public Button btnDial;
    public EditText editTextURL;
    public Button btnURL;
    public static final String EXTRA_MESSAGE =
            "com.example.myfirstapp.MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextURL = (EditText) findViewById(R.id.editTextURL);
        btnURL = (Button) findViewById(R.id.buttonURL);
        btnDial = (Button) findViewById(R.id.buttonDial);
        btnClickMe = (Button) findViewById(R.id.buttonClickMe);

        btnClickMe.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            String yName = editTextName.getText().toString();
            intent.putExtra("MESSAGE", yName);
            startActivity(intent);
        });

        btnDial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
        });
        btnURL.setOnClickListener(v -> {
            String url=editTextURL.getText().toString();
            Intent intent=new Intent(Intent.ACTION_VIEW,
                    Uri.parse(url));
            startActivity(intent);
        });
    }
}

