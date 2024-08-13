package com.example.collegefinder.Utilities;

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
import com.example.collegefinder.Model.ResponseModel;
import com.example.collegefinder.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder>{

    //List<ResponseModel> data;
    private ArrayList<ResponseModel> dataList;
    private LayoutInflater inflater;

    public MyAdapter(List<ResponseModel> dataList, Context context) {
        this.dataList = (ArrayList<ResponseModel>) dataList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        final ResponseModel data = dataList.get(position);

        holder.tvCollegeName.setText(data.getCollegeName());
        holder.tvProgram.setText(data.getProgram());
        holder.tvCollegeMail.setText(data.getCollegeMail());
        holder.tvCollegeLocation.setText(data.getCollegeLocation());
        holder.tvCollegeDistrict.setText(data.getCollegeDistrict());
        holder.tvCollegeContact.setText(data.getCollegeContact());
        holder.tvCollegePhone.setText(data.getCollegePhone());
        holder.tvCollegeWeb.setText(data.getCollegeWebsite());
        Glide.with(holder.collegeImage.getContext()).load("http://10.0.2.2/collegefinder/images/"+ data.getPhoto()).into(holder.collegeImage);

        Log.d("MyAdapter", "CollegeName: " + data.getCollegeName());

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder{
        ImageView collegeImage;
        TextView tvCollegeName, tvCollegeLocation, tvCollegeDistrict, tvCollegeWeb, tvCollegeContact, tvCollegePhone, tvCollegeMail, tvProgram;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            collegeImage = itemView.findViewById(R.id.collegeImage);
            tvCollegeName = itemView.findViewById(R.id.tvCollegeName);
            tvCollegeLocation = itemView.findViewById(R.id.tvCollegeLocation);
            tvCollegeDistrict = itemView.findViewById(R.id.tvCollegeDistrict);
            tvCollegeWeb = itemView.findViewById(R.id.tvCollegeWeb);
            tvCollegeContact = itemView.findViewById(R.id.tvCollegeContact);
            tvCollegePhone = itemView.findViewById(R.id.tvCollegePhone);
            tvCollegeMail = itemView.findViewById(R.id.tvCollegeMail);
            tvProgram = itemView.findViewById(R.id.tvProgram);
        }
    }

    public void updateList(ArrayList<ResponseModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }
}
