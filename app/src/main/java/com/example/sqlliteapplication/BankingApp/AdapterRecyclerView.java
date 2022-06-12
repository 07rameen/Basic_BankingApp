package com.example.sqlliteapplication.BankingApp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlliteapplication.R;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder> {

    Context context;
    ArrayList UID, Name, Email, Balance;
    RecyclerViewClickListener listener;

    public AdapterRecyclerView(Context context, ArrayList UID, ArrayList name, ArrayList email, ArrayList balance , RecyclerViewClickListener listener)
    {
        this.context = context;
        this.UID = UID;
        this.Name = name;
        this.Email = email;
        this.Balance = balance;
        this.listener=listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recylerviewrow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.uid.setText(String.valueOf(UID.get(position)));
        holder.name.setText(String.valueOf(Name.get(position)));
        holder.email.setText(String.valueOf(Email.get(position)));
        holder.balance.setText(String.valueOf(Balance.get(position)));

        //intent wali cheezein

    }

    @Override
    public int getItemCount() {
        return UID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        TextView uid, name,email,balance;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            uid= itemView.findViewById(R.id.idee);
            name = itemView.findViewById(R.id.namee);
            email=itemView.findViewById(R.id.emailll);
            balance=itemView.findViewById(R.id.balance);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            listener.OnClick(itemView,getAdapterPosition());

        }
    }

    public interface RecyclerViewClickListener{
        void OnClick(View view , int position);

    }


}
