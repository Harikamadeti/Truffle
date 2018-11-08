package com.example.win7.stylishapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2;
    TextView t1,t2,t3,t4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1=(EditText)findViewById(R.id.edittext1);
        e2=(EditText)findViewById(R.id.edittext2);
        b1=(Button)findViewById(R.id.button1);
        t3=(TextView)findViewById(R.id.text1);
        t4=(TextView)findViewById(R.id.text2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.length()<=0)
                {
                    e1.setError("please enter a valid email");
                }
               if (s2.length()<=0)
               {
                   e2.setError("please enter a valid password");
               }
               else
               {
                   Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                   startActivity(i);
               }
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(i1);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Main2Activity.this,Main5Activity.class);
                startActivity(i1);
            }
        });
    }
}
