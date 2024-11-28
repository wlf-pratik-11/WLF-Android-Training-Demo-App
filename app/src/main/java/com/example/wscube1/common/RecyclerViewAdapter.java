package com.example.wscube1.common;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wscube1.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ContactModel[] arrData;
    public RecyclerViewAdapter(Context context, ContactModel[] arrData){
        this.context = context;
        this.arrData = arrData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("onCreateViewHolder","onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.recler_view_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("Img","Img"+arrData[position].getImg());
        Glide.with(holder.itemView.getContext())
                .load(arrData[position].getImg())
                .into(holder.imgForCardRecycler);
        holder.nameText.setText(arrData[position].getName());
        holder.contactText.setText(arrData[position].getNumber());

    }

    @Override
    public int getItemCount() {
        return arrData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameText,contactText;
        ImageView imgForCardRecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgForCardRecycler = itemView.findViewById(R.id.imgForCardRecycler);
            nameText = itemView.findViewById(R.id.nameText);
            contactText = itemView.findViewById(R.id.contactText);


        }
    }
}
