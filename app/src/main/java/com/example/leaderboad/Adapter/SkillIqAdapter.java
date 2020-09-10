package com.example.leaderboad.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.Model.SkillIqModel;
import com.example.leaderboad.R;

import java.util.List;


public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.SkillViewHolder> {

    List<SkillIqModel> skillIqModelList;
    Context context;

    public SkillIqAdapter() {

    }

    public void setSkillData(List<SkillIqModel> skillIqModels) {
        this.skillIqModelList = skillIqModels;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SkillIqAdapter.SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SkillIqAdapter.SkillViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_skill_iq, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqAdapter.SkillViewHolder holder, int position) {
        SkillIqModel skillIqModel = skillIqModelList.get(position);

        int image = skillIqModel.getSkillImage();
        String name = skillIqModel.getSkillIqName();
        String skill_iq = skillIqModel.getSkillIq();

        holder.skillImage.setImageResource(image);
        holder.tvName.setText(name);
        holder.tvSkillIq.setText(skill_iq);
    }

    @Override
    public int getItemCount() {
        return skillIqModelList.size();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {

        ImageView skillImage;
        TextView tvName;
        TextView tvSkillIq;
        public SkillViewHolder(@NonNull View itemView) {
            super( itemView );

            skillImage = itemView.findViewById(R.id.imgSkill);
            tvName = itemView.findViewById(R.id.txtSkillName);
            tvSkillIq = itemView.findViewById(R.id.txtSkillIq);
        }
    }
}
