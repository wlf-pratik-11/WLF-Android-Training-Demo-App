package com.example.wscube1.FirebaseDemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscube1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CourceRVAdapter extends RecyclerView.Adapter<CourceRVAdapter.ViewHolder> {
    private ArrayList<CourceModel> courceModelArrayList;
    private Context context;
    int lastPosition = -1;
    private CourceClickInterface courceClickInterface;

    public CourceRVAdapter(ArrayList<CourceModel> courceModelArrayList, Context context, CourceClickInterface courceClickInterface) {
        this.courceModelArrayList = courceModelArrayList;
        this.context = context;
        this.courceClickInterface = courceClickInterface;
    }

    @NonNull
    @Override
    public CourceRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cource_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourceRVAdapter.ViewHolder holder, int position) {
        CourceModel courceModel = courceModelArrayList.get(position);
        holder.TVCource.setText(courceModel.getCourceName());
        holder.TVPrice.setText("Rs. "+courceModel.getCourcePrice());
        Picasso.get().load(courceModel.getCourceImgLink()).into(holder.IVCource);
        setAnimation(holder.itemView,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courceClickInterface.onCourceClick(position);
            }
        });
    }

    private void setAnimation(View view,int position){
        if(position>lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.setAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return courceModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView TVCource,TVPrice;
        private ImageView IVCource;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TVCource = itemView.findViewById(R.id.TVCource);
            TVPrice = itemView.findViewById(R.id.TVPrice);
            IVCource = itemView.findViewById(R.id.IVCource);


        }
    }

    public interface CourceClickInterface{
        void onCourceClick(int position);
    }
}
