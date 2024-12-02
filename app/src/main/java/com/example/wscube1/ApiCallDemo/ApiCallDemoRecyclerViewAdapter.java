package com.example.wscube1.ApiCallDemo;

import android.net.Uri;
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
import com.example.wscube1.common.RecyclerViewAdapter;

import java.util.List;

public class ApiCallDemoRecyclerViewAdapter extends RecyclerView.Adapter<ApiCallDemoRecyclerViewAdapter.userHolder> {
    ApiCallDemoActivity apiCallDemoActivity;
    List<UserModel> allUsersList;
    public ApiCallDemoRecyclerViewAdapter(ApiCallDemoActivity apiCallDemoActivity, List<UserModel> allUsersList) {
        this.apiCallDemoActivity = apiCallDemoActivity;
        this.allUsersList = allUsersList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(apiCallDemoActivity).inflate(R.layout.card_for_api_call_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(Uri.parse(allUsersList.get(position).getUserImg())).into(holder.userImg);
        holder.userName.setText(allUsersList.get(position).getUserName());
        holder.userCity.setText(allUsersList.get(position).getCity());
        holder.userBirthDate.setText(allUsersList.get(position).getDateOfBirth());
        holder.userEmail.setText(allUsersList.get(position).getEmail());
        holder.userNumber.setText(allUsersList.get(position).getMobileNumber());
    Log.d("Dataaa","Data IS :"+allUsersList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return allUsersList.size();
    }

    class userHolder extends RecyclerView.ViewHolder {
        ImageView userImg;
        TextView userName,userCity,userBirthDate,userEmail,userNumber;
        public userHolder(@NonNull View itemView) {
            super(itemView);
            userImg = itemView.findViewById(R.id.userImg);
            userName = itemView.findViewById(R.id.userName);
            userCity = itemView.findViewById(R.id.userCity);
            userBirthDate = itemView.findViewById(R.id.userBirthDate);
            userEmail = itemView.findViewById(R.id.userEmail);
            userNumber = itemView.findViewById(R.id.userNumber);



        }
    }
}
