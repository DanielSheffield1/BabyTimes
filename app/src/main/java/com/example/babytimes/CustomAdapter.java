package com.example.babytimes;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList user_id, user_firstName, user_lastName, user_email, user_username, user_password;

    CustomAdapter(Activity activity, Context context, ArrayList user_id, ArrayList user_firstName, ArrayList user_lastName,
                  ArrayList user_email, ArrayList user_username, ArrayList user_password){
        this.activity = activity;
        this.context = context;
        this.user_id = user_id;
        this.user_firstName = user_firstName;
        this.user_lastName = user_lastName;
        this.user_email = user_email;
        this.user_username = user_username;
        this.user_password = user_password;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if (holder.user_id_txt != null) {
            holder.user_id_txt.setText(String.valueOf(user_id.get(position)));
        }
        if (holder.user_firstName_txt != null) {
            holder.user_firstName_txt.setText(String.valueOf(user_firstName.get(position)));
        }
        if (holder.user_lastName_txt != null) {
            holder.user_lastName_txt.setText(String.valueOf(user_lastName.get(position)));
        }
        if (holder.user_email_txt != null) {
            holder.user_email_txt.setText(String.valueOf(user_email.get(position)));
        }
        if (holder.user_username_txt != null) {
            holder.user_username_txt.setText(String.valueOf(user_username.get(position)));
        }
        if (holder.user_password_txt != null) {
            holder.user_password_txt.setText(String.valueOf(user_password.get(position)));
        }
        //Recyclerview onClickListener
        holder.my_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, com.example.babytimes.UpdateActivity.class);
                intent.putExtra("id", String.valueOf(user_id.get(position)));
                intent.putExtra("firstName", String.valueOf(user_firstName.get(position)));
                intent.putExtra("lastName", String.valueOf(user_lastName.get(position)));
                intent.putExtra("email", String.valueOf(user_email.get(position)));
                intent.putExtra("username", String.valueOf(user_username.get(position)));
                intent.putExtra("password", String.valueOf(user_password.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_id_txt, user_firstName_txt, user_lastName_txt, user_email_txt, user_username_txt, user_password_txt;
        LinearLayout my_row;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id_txt = itemView.findViewById(R.id.user_id_txt);
            user_firstName_txt = itemView.findViewById(R.id.user_firstName_txt);
            user_lastName_txt = itemView.findViewById(R.id.user_lastName_txt);
            user_email_txt = itemView.findViewById(R.id.user_email_txt);
            user_username_txt = itemView.findViewById(R.id.user_username_txt);
            user_password_txt = itemView.findViewById(R.id.user_password_txt);
            my_row = itemView.findViewById(R.id.my_row);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            my_row.setAnimation(translate_anim);
        }

    }

}