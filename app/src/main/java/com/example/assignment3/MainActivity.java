package com.example.assignment3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ph,psw;
    Button btn1,btn2;
    String sna2,pwd;
    Emp emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ph=findViewById(R.id.editTextTextPersonName2);
        psw=findViewById(R.id.editTextTextPassword2);
        btn1=findViewById(R.id.button3);
        btn2=findViewById(R.id.button4);
        emp=new Emp(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sna2=ph.getText().toString();
                ArrayList<String> s = emp.retrvloc(sna2);
                pwd = psw.getText().toString();
                String password= s.get(0);
                if(pwd.equals(password))
                {
                    Toast.makeText(getApplicationContext(), "sucessfully Login", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,MainActivity3.class);
                    i.putExtra("sname",s.get(1));
                    i.putExtra("loc","Your location is "+s.get(2));
                    i.putExtra("pn","Your Phone number is "+sna2);
                    i.putExtra("pwd","Your Password is "+pwd);
                    startActivity(i);
                }
                else{
                    //Toast.makeText(getApplicationContext(), "Fail"+password + " "+pwd, Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                    b.setMessage("this is msg");
                    b.setTitle("this is title");
                    b.setIcon(android.R.drawable.ic_media_play);
                    b.setNegativeButton("Invalid Password", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                        }
                    });
                    b.show();
                }
              //  tv.setText(dbloc);

            }
        });
    }
}