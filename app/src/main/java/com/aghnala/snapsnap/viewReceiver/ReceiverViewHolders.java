package com.aghnala.snapsnap.viewReceiver;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.aghnala.snapsnap.R;

public class ReceiverViewHolders  extends RecyclerView.ViewHolder {

    public TextView mEmail;
    public CheckBox mReceive;

    public ReceiverViewHolders(View itemView){
        super(itemView);
        mEmail = itemView.findViewById(R.id.email);
        mReceive = itemView.findViewById(R.id.receive);

    }

}
