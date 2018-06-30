package com.example.zain.chatapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zain.chatapplication.Adapter.ChatViewAdapter;
import com.example.zain.chatapplication.Adapter.RecyclerViewAdapter;
import com.example.zain.chatapplication.Common.Common;
import com.example.zain.chatapplication.Database.AppDatabase;
import com.example.zain.chatapplication.Database.Messages;
import com.example.zain.chatapplication.Interface.ItemClickListener;
import com.example.zain.chatapplication.Model.User;

import java.util.List;

public class ChatPlatformActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView t1, t2;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_platform);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Cabin-Bold.ttf");

        toolbar = findViewById(R.id.toolbar);
        t1 = toolbar.findViewById(R.id.user_id);
        t1.setTypeface(custom_font);
        t2 = toolbar.findViewById(R.id.last_seen);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Room Database
        AppDatabase db = AppDatabase.getInstance(this);



        recyclerView = findViewById(R.id.recyclerViewChat);
        recyclerView.setHasFixedSize(true);
        final ChatViewAdapter recyclerViewAdapter = new ChatViewAdapter();
        recyclerViewAdapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(view.getContext(), "WOW", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_platform_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
