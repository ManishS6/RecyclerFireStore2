package com.guidoapps.recyclerfirestore;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    MainActivity mainActivity;
    ArrayList<User> userArrayList;
    String uri = "com.whatsapp";
    String mesg = "Hey! Download this new Application called PayNav from the Google Play Store or Apple App Store.";


    public MyRecyclerViewAdapter(MainActivity mainActivity, ArrayList<User> userArrayList) {
        this.mainActivity= mainActivity;
        this.userArrayList=userArrayList;
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.single_row,parent,false);


        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, final int position) {
        holder.mUserName.setText(userArrayList.get(position).getUserName());
        holder.mUserStatus.setText(userArrayList.get(position).getUserStatus());
        holder.mInviteRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + userArrayList.get(position).getUserStatus().toString()+"&text="+ mesg));
            }
        });


    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }




}


