package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Button btn2;
    TextView lbText;


    private View.OnLongClickListener longClick = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        lbText = findViewById(R.id.lblText);
        lbText.setOnLongClickListener(longClick);

    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        if (btn.getId() == R.id.button)
            Toast.makeText(this, "Up", Toast.LENGTH_SHORT).show();
        if (btn.getId() == R.id.button2)
            Toast.makeText(this, "Down", Toast.LENGTH_SHORT).show();
    }
}