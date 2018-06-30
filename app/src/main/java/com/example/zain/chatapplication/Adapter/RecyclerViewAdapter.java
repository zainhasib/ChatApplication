package com.example.zain.chatapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zain.chatapplication.Interface.ItemClickListener;
import com.example.zain.chatapplication.Model.ChatItem;
import com.example.zain.chatapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static ItemClickListener itemClickListener;
    public List<ChatItem> list;

    public RecyclerViewAdapter(List<ChatItem> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CircleImageView circleImageView;
        public TextView itemName, lastChat, clock;

        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.profile_image);
            itemName = itemView.findViewById(R.id.item_name);
            lastChat = itemView.findViewById(R.id.last_chat);
            clock = itemView.findViewById(R.id.clock);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }

    public void ItemClickListeners(ItemClickListener itemClickListener) {
        RecyclerViewAdapter.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_fragment_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
