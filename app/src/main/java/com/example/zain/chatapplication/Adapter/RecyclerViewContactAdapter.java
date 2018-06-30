package com.example.zain.chatapplication.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zain.chatapplication.Interface.ItemClickListener;
import com.example.zain.chatapplication.Model.ChatItem;
import com.example.zain.chatapplication.Model.User;
import com.example.zain.chatapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

public class RecyclerViewContactAdapter extends RecyclerView.Adapter<RecyclerViewContactAdapter.MyViewHolder>{

    private static ItemClickListener listener;
    private List<User> list;

    public RecyclerViewContactAdapter(List<User> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public CircleImageView circleImageView;
        public TextView itemName, clock;

        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.profile_image);
            itemName = itemView.findViewById(R.id.item_name);
            clock = itemView.findViewById(R.id.mobile);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e(TAG, "onClick: " );
            listener.onClick(view, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ItemClickListener clickListener) {
        RecyclerViewContactAdapter.listener = clickListener;
    }


    @NonNull
    @Override
    public RecyclerViewContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_fragment_item, parent, false);
        return new RecyclerViewContactAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewContactAdapter.MyViewHolder holder, int position) {
        if (list.get(position).name != "") {
            holder.itemName.setText(list.get(position).name);
        }else {
            holder.itemName.setText(list.get(position).phoneNo);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
