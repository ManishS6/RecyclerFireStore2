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

public class MyAdapterPN extends RecyclerView.Adapter<MyHolderPN> {
    MainActivity mainActivity;
    ArrayList<User> userArrayList2;
    String uri = "com.whatsapp";



    public MyAdapterPN (MainActivity mainActivity, ArrayList<User> userArrayList2) {
        this.mainActivity= mainActivity;
        this.userArrayList2=userArrayList2;
    }

    @NonNull
    @Override
    public MyHolderPN onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater2 = LayoutInflater.from(mainActivity.getBaseContext());
        View view = layoutInflater2.inflate(R.layout.single_row_installed,parent,false);


        return new MyHolderPN(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolderPN holder, final int position) {
        holder.mUserName2.setText(userArrayList2.get(position).getUserName());
        holder.mUserStatus2.setText(userArrayList2.get(position).getUserStatus());
        holder.mInviteRow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+919773657209"+"&text="+ "Hey Send Some Money On PayNav Please"));
            }
        });


    }

    @Override
    public int getItemCount() {
        return userArrayList2.size();
    }




}
