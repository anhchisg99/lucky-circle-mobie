package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText username,password;
    Button m2_btn2,m2_btn1;
    ArrayList<Users> mUsers;
    //function
    public int Count(ArrayList<Users> args){
        return args.size();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        m2_btn1 = findViewById(R.id.m2_btn1);
        m2_btn2 = findViewById(R.id.m2_btn2);
        mUsers = new ArrayList<Users>();


        m2_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = username.getText().toString();
                String name = password.getText().toString();
                if(Count(mUsers) >=4){
                    Toast.makeText(MainActivity2.this,"cannot add more people",Toast.LENGTH_LONG).show();
                }else{
                    if(id.equals("")){
                        Toast.makeText(MainActivity2.this,"you must fill in Id",Toast.LENGTH_LONG).show();
                    }else if(name.equals("")){
                        Toast.makeText(MainActivity2.this,"you must fill in Name",Toast.LENGTH_LONG).show();
                    }else{
                        mUsers.add(new Users(id,name));
//                int count = Count(mUsers);
                        username.setText("");
                        password.setText("");
                    }

                }

            }
        });

        m2_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
                i.putParcelableArrayListExtra("data",mUsers);

                startActivity(i);
            }
        });

    }

}