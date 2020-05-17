package com.guidoapps.recyclerfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView mRecyclerView,mRecyclerView2;
    ArrayList<User> userArrayList,userArrayList2;
    MyRecyclerViewAdapter adapter;
    MyAdapterPN adapter2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userArrayList = new ArrayList<>();
        userArrayList2 = new ArrayList<>();
        setUpRecyclerView();
        setUpFireBase();
        addTestDataToFirebase();
        loadDataFromFirebase();
//        EditText editText = findViewById(R.id.searching);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                filter(s.toString());
//            }
//        });
    }

    private void loadDataFromFirebase() {

//        if (userArrayList.size()>0)/

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot querySnapshot: task.getResult()){
                            User user = new User(querySnapshot.getString("name"),querySnapshot.getString("status"));
                            userArrayList.add(user);
                        }
                        adapter = new MyRecyclerViewAdapter(MainActivity.this, userArrayList);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Problem ---i---",Toast.LENGTH_SHORT).show();
                        Log.w("----i-----",e.getMessage());
                    }
                });

                db.collection("paynavusers")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot querySnapshot: task.getResult()){
                            User user2 = new User(querySnapshot.getString("name"),querySnapshot.getString("status"));
                            userArrayList2.add(user2);
                        }
                        adapter2 = new MyAdapterPN(MainActivity.this, userArrayList2);
                        mRecyclerView2.setAdapter(adapter2);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Problem ---i---",Toast.LENGTH_SHORT).show();
                        Log.w("----i-----",e.getMessage());
                    }
                });
    }

    private void addTestDataToFirebase() {

    }

    private void setUpFireBase() {
        db= FirebaseFirestore.getInstance();
    }

    private void setUpRecyclerView() {
        mRecyclerView= findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView2=findViewById(R.id.mRecyclerView2);
        mRecyclerView2.setHasFixedSize(true);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this));

    }

}
