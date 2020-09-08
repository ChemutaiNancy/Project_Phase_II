package com.example.leaderboad.Adapter;

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


public class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.ViewHolder> {

    List<SkillIqModel> skillIqModels;

    @NonNull
    @Override
    public SkillIqAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_skill_iq, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqAdapter.ViewHolder holder, int position) {
        holder.imgSkillIq.setImageResource(skillIqModels.get(position).getSkillImage());
        holder.tvSkillName.setText(skillIqModels.get(position).getSkillIqName());
        holder.tvSkill.setText(skillIqModels.get(position).getSkillIq());
    }

    @Override
    public int getItemCount() {
        return skillIqModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSkillIq;
        TextView tvSkillName;
        TextView tvSkill;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSkillIq = itemView.findViewById(R.id.imgSkill);
            tvSkillName = itemView.findViewById(R.id.txtSkillName);
            tvSkill = itemView.findViewById(R.id.txtSkillIq);
        }
    }
}
