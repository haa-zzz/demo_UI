package com.example.revise_3_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> list = new ArrayList<>();
    private EditText editText;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addList();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final MyAdapt adapt = new MyAdapt(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapt);
        editText = (EditText)findViewById(R.id.editText);
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                Msg msg = new Msg(Msg.TYPE_SEND,message);
                editText.setText("");
                list.add(msg);
                adapt.notifyDataSetChanged();       //刷新操作
            }
        });


    }

    private void addList() {
        Msg msg = new Msg(0,"13434");
        Msg msg1 = new Msg(1,"13434");
        Msg msg2 = new Msg(0,"13434");
        Msg msg3 = new Msg(1,"13434");
        Msg msg4 = new Msg(0,"13434");
        list.add(msg);
        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
        list.add(msg4);
    }
}