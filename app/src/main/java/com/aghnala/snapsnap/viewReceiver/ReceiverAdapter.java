package com.aghnala.snapsnap.viewReceiver;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aghnala.snapsnap.R;

import java.util.List;

public class ReceiverAdapter extends RecyclerView.Adapter<ReceiverViewHolders> {
    private List<ReceiverObject> usersList;
    private Context context;

    public ReceiverAdapter(List<ReceiverObject> usersList, Context context){
        this.usersList = usersList;
        this.context = context;
    }
    @Override
    public ReceiverViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_receiver_item, null);
        ReceiverViewHolders rcv = new ReceiverViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final ReceiverViewHolders holder, int position) {
        holder.mEmail.setText(usersList.get(position).getEmail());
        holder.mReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean receiveState = !usersList.get(holder.getLayoutPosition()).getReceive();
                usersList.get(holder.getLayoutPosition()).setReceive(receiveState);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }
}
