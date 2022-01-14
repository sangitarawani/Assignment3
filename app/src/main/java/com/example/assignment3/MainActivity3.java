package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button btn;
    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn=findViewById(R.id.button2);
        t1=findViewById(R.id.textView8);
        t2=findViewById(R.id.textView9);
        t3=findViewById(R.id.textView10);
        t4=findViewById(R.id.textView11);

        String d = getIntent().getStringExtra("sname");
        t1.setText(d);

        String d2 = getIntent().getStringExtra("loc");
        t2.setText(d2);

        String d3 = getIntent().getStringExtra("pn");
        t3.setText(d3);

        String d4 = getIntent().getStringExtra("pwd");
        t4.setText(d4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}