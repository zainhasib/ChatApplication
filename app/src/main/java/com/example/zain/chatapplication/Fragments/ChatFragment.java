package com.example.zain.chatapplication.Fragments;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zain.chatapplication.Adapter.RecyclerViewAdapter;
import com.example.zain.chatapplication.ChatPlatformActivity;
import com.example.zain.chatapplication.Common.Common;
import com.example.zain.chatapplication.Interface.ItemClickListener;
import com.example.zain.chatapplication.Model.ChatItem;
import com.example.zain.chatapplication.R;

import java.util.List;

import javax.security.auth.login.LoginException;

import de.mateware.snacky.Snacky;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChatItem[] c;
    private List<ChatItem> listOfChatItem;
    private FloatingActionButton fab;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snacky.builder()
                        .setView(view)
                        .setText("Clicked")
                        .setIcon(R.drawable.ic_check_white_24dp)
                        .success()
                        .show();
            }
        });

        AsyncTaskRunner runner = new AsyncTaskRunner();
        runner.execute();

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(listOfChatItem);
        recyclerViewAdapter.ItemClickListeners(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(view.getContext(), "WOW", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ChatPlatformActivity.class);
                Log.e(TAG, String.valueOf(position));
                //Common.chatItem = listOfChatItem.get(position);
                //Log.e(TAG, Common.chatItem.toString());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        return view;
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;

        @Override
        protected String doInBackground(String... params) {
            try {

                listOfChatItem.add(new ChatItem("wqe", "eqw", "eqw", "eqw", "7205929025"));
                listOfChatItem.add(new ChatItem("wqe", "eqw", "eqw", "eqw", "7205929021"));
                listOfChatItem.add(new ChatItem("wqe", "eqw", "eqw", "eqw", "7205929022"));
                listOfChatItem.add(new ChatItem("wqe", "eqw", "eqw", "eqw", "7205929023"));
                listOfChatItem.add(new ChatItem("wqe", "eqw", "eqw", "eqw", "7205929024"));
                listOfChatItem.add(new ChatItem("wqe", "eqw", "eqw", "eqw", "7205929026"));

                Log.e(TAG, listOfChatItem.get(0).getPhoneNo() );
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }
    }

}
