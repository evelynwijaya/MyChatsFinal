package com.example.lenovo.mychats;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myUser = database.getReference("users");

    ArrayList<User> users = new ArrayList<>();
    RecyclerView rv_user;
    UserListAdapter adapter;
    User user;
    SharedPreferences mylocaldata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        mylocaldata= getSharedPreferences("mylocaldata",MODE_PRIVATE);
        user = getIntent().getParcelableExtra("user");
        myUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    User user = postSnapshot.getValue(User.class);
                    users.add(user);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        rv_user = (RecyclerView)findViewById(R.id.rv_user);
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(this,users);
        rv_user.setAdapter(adapter);

    }
}
