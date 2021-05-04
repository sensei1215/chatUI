package com.example.chatui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    ImageView dp;
    TextView name;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        dp=findViewById(R.id.dp);
        name=findViewById(R.id.nameText);
        msg=findViewById(R.id.msg);
        setData();
    }

    private  void setData(){
        name.setText(getIntent().getStringExtra("Name"));
        msg.setText(getIntent().getStringExtra("Message"));
        dp.setImageResource(getIntent().getIntExtra("DP",1));
    }
}
