package com.guidoapps.recyclerfirestore;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolderPN extends RecyclerView.ViewHolder {
    public TextView mUserName2,mUserStatus2;
    public Button mInviteRow2;


    public MyHolderPN(@NonNull View itemView) {
        super(itemView);
        mUserName2 = itemView.findViewById(R.id.mRowUserName2);
        mUserStatus2 = itemView.findViewById(R.id.mRowUserStatus2);
        mInviteRow2 = itemView.findViewById(R.id.mRowDeleteButton2);
    }
}
