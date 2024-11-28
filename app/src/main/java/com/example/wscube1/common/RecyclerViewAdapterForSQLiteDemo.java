package com.example.wscube1.common;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wscube1.AddContactPageActivity;
import com.example.wscube1.R;
import com.example.wscube1.SQLiteDemoActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterForSQLiteDemo extends RecyclerView.Adapter<RecyclerViewAdapterForSQLiteDemo.ViewHolder> {
    SQLiteDemoActivity activity;
    Context context;
    List<Contact> arrData;
    RecyclerView contactListView;
    private static final int ADD_CONTACT_REQ_CODE = 100,DELETE_CONTACT_REQ_CODE = 200;

    public RecyclerViewAdapterForSQLiteDemo(SQLiteDemoActivity activity,Context context, List<Contact> arrData) {
        this.activity = activity;
        this.context = context;
        this.arrData = arrData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterForSQLiteDemo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_for_contactview, parent, false);
        RecyclerViewAdapterForSQLiteDemo.ViewHolder viewHolder = new RecyclerViewAdapterForSQLiteDemo.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterForSQLiteDemo.ViewHolder holder, int position) {

        Contact currentModel = arrData.get(holder.getAdapterPosition());

        holder.contactName.setText(currentModel.getName());
        holder.contactNumber.setText(currentModel.getPhoneNumber());

        holder.contactEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, AddContactPageActivity.class);
                intent.putExtra("id", String.valueOf(currentModel.getID())); // Pass the ID for editing
                intent.putExtra("name", currentModel.getName());
                intent.putExtra("phoneNumber", currentModel.getPhoneNumber());
                activity.startActivityForResult(intent, ADD_CONTACT_REQ_CODE);
            }
        });

        holder.contactDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(activity);

                alert.setTitle("Delete entry");
                alert.setMessage("Are you sure you want to delete?");
                alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    DatabaseHandler db = new DatabaseHandler(activity);

                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteContact(currentModel);
                        arrData.remove(currentModel);
                        notifyItemRemoved(holder.getAdapterPosition());
                        notifyItemRangeChanged(holder.getAdapterPosition(), arrData.size());
                    }
                });
                alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contactName, contactNumber;
        ImageView contactEdit, contactDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);
            contactEdit = itemView.findViewById(R.id.contactEdit);
            contactDelete = itemView.findViewById(R.id.contactDelete);
            contactListView = itemView.findViewById(R.id.contactListView);


        }
    }
}
