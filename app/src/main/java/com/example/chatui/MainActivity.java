package com.example.chatui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    String contacts[],msg[];
    RecyclerView rv;
    public static int img[]= {R.drawable.hippo,R.drawable.monkey,R.drawable.panda,R.drawable.parrot,R.drawable.penguin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.recyclerView);

        contacts=getResources().getStringArray(R.array.Contacts);
        msg=getResources().getStringArray(R.array.Msg);

        CustomAdapter customAdapter= new CustomAdapter(this,contacts,msg,img);
        rv.setAdapter(customAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
