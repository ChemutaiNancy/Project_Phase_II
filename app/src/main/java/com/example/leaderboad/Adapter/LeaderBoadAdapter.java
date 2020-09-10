package com.example.leaderboad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.Model.LeaderboadModel;
import com.example.leaderboad.Model.SkillIqModel;
import com.example.leaderboad.R;

import java.util.List;

public class LeaderBoadAdapter extends RecyclerView.Adapter<LeaderBoadAdapter.LeaderBoadViewHolder>{

    List<LeaderboadModel> leaderboadModels;
    Context context;

    public LeaderBoadAdapter() {
    }

    public void setLeaderboadDetails(List<LeaderboadModel> leaderboadModelList){
        this.leaderboadModels = leaderboadModelList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public LeaderBoadAdapter.LeaderBoadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new LeaderBoadAdapter.LeaderBoadViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_leaderboad, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoadAdapter.LeaderBoadViewHolder holder, int position) {
        LeaderboadModel leaderboadModel = leaderboadModels.get(position);

        int image = leaderboadModel.getLeaderboadImage();
        String name = leaderboadModel.getLeaderboadName();
        String skill_iq = leaderboadModel.getLeaderboadHour();

        holder.leaderImage.setImageResource(image);
        holder.tvLeaderName.setText(name);
        holder.tvLeaderHours.setText(skill_iq);
    }

    @Override
    public int getItemCount() {
        return leaderboadModels.size();
    }

    public class LeaderBoadViewHolder extends RecyclerView.ViewHolder {
        ImageView leaderImage;
        TextView tvLeaderName;
        TextView tvLeaderHours;
        public LeaderBoadViewHolder(@NonNull View itemView) {
            super( itemView );

            leaderImage = itemView.findViewById(R.id.imgLeaderboad);
            tvLeaderName = itemView.findViewById(R.id.txtName);
            tvLeaderHours = itemView.findViewById(R.id.txtHours);
        }
    }
}
