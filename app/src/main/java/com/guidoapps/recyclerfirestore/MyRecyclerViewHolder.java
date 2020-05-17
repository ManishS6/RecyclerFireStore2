package com.guidoapps.recyclerfirestore;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView mUserName,mUserStatus;
    public Button mInviteRow;


    public MyRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        mUserName = itemView.findViewById(R.id.mRowUserName);
        mUserStatus = itemView.findViewById(R.id.mRowUserStatus);
        mInviteRow = itemView.findViewById(R.id.mRowDeleteButton);
    }
}
