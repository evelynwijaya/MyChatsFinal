package com.example.lenovo.mychats;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Lenovo on 05/01/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UsersHolder>{
    List<User> users;
//    private LayoutInflater inflater;
    private Context context;
    SharedPreferences mylocaldata;


    public UserListAdapter(Context context, List<User> users) {
        this.context = context;
//        inflater = LayoutInflater.from(context);
        this.users = users;
        mylocaldata = context.getSharedPreferences("mylocaldata",Context.MODE_PRIVATE);
    }

    @Override
    public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent,false);
        UsersHolder holder = new UsersHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(UsersHolder holder, int position) {
        User current = users.get(position);
        holder.setData(current,position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder {
//        View itemView;
        TextView tv_nama, tv_telepon, tv_email;
        LinearLayout lv_detail;
        CardView thisuser;
        int position;
        User current;


        public UsersHolder(View itemView) {
            super(itemView);
//            this.itemView = itemView;
            thisuser = (CardView)itemView.findViewById(R.id.cv_itemUser);
            tv_nama = (TextView)itemView.findViewById(R.id.tv_nama);
            tv_email = (TextView)itemView.findViewById(R.id.tv_email);
            tv_telepon = (TextView)itemView.findViewById(R.id.tv_telepon);
            lv_detail = (LinearLayout)itemView.findViewById(R.id.lv_detail);
        }

        public void setData(User current, int position) {
            tv_nama. setText(current.getNama());
            tv_telepon.setText(current.getTelepon());
            tv_email.setText(current.getEmail());
            String uid = mylocaldata.getString("uid","");
            this.position = position;
            this.current = current;

        }


        public void setListeners() {
            tv_nama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lv_detail.getVisibility() == View.GONE){
                        lv_detail.setVisibility(View.VISIBLE);
                    }else
                        lv_detail.setVisibility(View.GONE);
                }
            });
        }
    }
}
