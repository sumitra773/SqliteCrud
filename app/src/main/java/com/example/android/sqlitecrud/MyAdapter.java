package com.example.android.sqlitecrud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder>
{
    ArrayList<Modal> dataHolder;

    public MyAdapter(ArrayList<Modal> dataHolder) {
        this.dataHolder = dataHolder;
    }




    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.dName.setText(dataHolder.get(position).getName());
        holder.dContact.setText(dataHolder.get(position).getContact());
        holder.dEmail.setText(dataHolder.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder

    {
        TextView dName,dContact,dEmail;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            dName = (TextView)itemView.findViewById(R.id.display_name);
            dContact = (TextView)itemView.findViewById(R.id.display_contact);
            dEmail = (TextView)itemView.findViewById(R.id.display_email);
        }
    }
}
