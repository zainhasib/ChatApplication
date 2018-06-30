package com.example.zain.chatapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zain.chatapplication.Common.Common;
import com.example.zain.chatapplication.Database.Messages;
import com.example.zain.chatapplication.Interface.ItemClickListener;
import com.example.zain.chatapplication.Model.User;
import com.example.zain.chatapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

public class ChatViewAdapter extends RecyclerView.Adapter<ChatViewAdapter.MyViewHolder> {

    private static ItemClickListener listener;
    private List<User> list;
    public List<Messages> listOfMsg;

    public ChatViewAdapter(List<Messages> listOfMsg) {
        this.listOfMsg = listOfMsg;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public CircleImageView circleImageView;
        public TextView itemName, clock;

        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circularViewImage);
            itemName = itemView.findViewById(R.id.msg);
            clock = itemView.findViewById(R.id.time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e(TAG, "onClick: " );
            listener.onClick(view, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ItemClickListener clickListener) {
        ChatViewAdapter.listener = clickListener;
    }

    @Override
    public int getItemViewType(int position) {
        String p = listOfMsg.get(position).getPhoneNo();
        if (p.equals(Common.user.phoneNo)) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public ChatViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0 : return new ChatViewAdapter.MyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_button_right, parent, false));
            case 1 : return new ChatViewAdapter.MyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_button, parent, false));
            default: return new ChatViewAdapter.MyViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_button_right, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
