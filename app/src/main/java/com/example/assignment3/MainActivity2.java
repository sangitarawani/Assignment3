package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText name,mob,psw,loc;
    Button b1;
    Emp emp;
    //TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name=findViewById(R.id.editTextTextPersonName);
        mob=findViewById(R.id.editTextTextPersonName3);
        psw=findViewById(R.id.editTextTextPassword);
        loc=findViewById(R.id.editTextTextPersonName4);
        b1=findViewById(R.id.button);
        //t=findViewById(R.id.textView);
        emp=new Emp(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String names=name.getText().toString();
                String mobs =mob.getText().toString();
                String ps = psw.getText().toString();
                String ls = loc.getText().toString();
                //Toast.makeText(getApplicationContext(), names+mobs+ps+ls, Toast.LENGTH_SHORT).show();
                 emp.savedb(names,mobs,ps,ls);
                //t.setText(s);
                Toast.makeText(getApplicationContext(), "Thanks for Sign up!!" , Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);

                //Toast.makeText(getApplicationContext(), "Sign up done", Toast.LENGTH_SHORT).show();
            }
        });


    }

//    public void savedata(View view) {
//        String names=name.getText().toString();
//        String mobs =mob.getText().toString();
//        String psws = psw.getText().toString();
//        String locs = loc.getText().toString();
//
//        emp.savetodb(names,mobs,psws,locs);
//        Toast.makeText(getApplicationContext(), "Data saved successfully!!", Toast.LENGTH_SHORT).show();
//
//    }
}