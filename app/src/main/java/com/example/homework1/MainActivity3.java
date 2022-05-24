package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView rcvUser;
    //    private ArrayList<User> mUsers;
    private CustomAdapter customAdapter;
    Button m3_btn1;
    ArrayList<Users> mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        m3_btn1 = findViewById(R.id.m3_btn1);
        ArrayList<Users> mUsers = getIntent().getParcelableArrayListExtra("data");
        rcvUser = findViewById(R.id.rcv1);
//        mUsers = new ArrayList<User>();
//        mUsers.add(new User("cuong","chan"));
//        mUsers.add(new User("cuong1","chan1"));
//        mUsers.add(new User("cuong2","chan2 "));
//
        customAdapter = new CustomAdapter(mUsers,this);
        rcvUser.setAdapter(customAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(new LinearLayoutManager(this));
        m3_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this, MainActivity4.class);
                i.putParcelableArrayListExtra("data",mUsers);
                startActivity(i);
            }
        });
//
    }
}