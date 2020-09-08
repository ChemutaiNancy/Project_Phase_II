package com.example.leaderboad.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.Model.LeaderboadModel;
import com.example.leaderboad.R;

import java.util.List;

public class LeaderBoadAdapter extends RecyclerView.Adapter<LeaderBoadAdapter.ViewHolder>{

    List<LeaderboadModel> leaderboadModels;
    @NonNull
    @Override
    public LeaderBoadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_leaderboad, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoadAdapter.ViewHolder holder, int position) {
        holder.imgLeaderboad.setImageResource(leaderboadModels.get(position).getLeaderboadImage());
        holder.tvName.setText(leaderboadModels.get(position).getLeaderboadName());
        holder.tvHours.setText(leaderboadModels.get(position).getLeaderboadHour());
    }

    @Override
    public int getItemCount() {
        return leaderboadModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imgLeaderboad;
        private TextView tvName;
        private TextView tvHours;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLeaderboad = itemView.findViewById(R.id.imgLeaderboad);
            tvName = itemView.findViewById(R.id.txtName);
            tvHours = itemView.findViewById(R.id.txtHours);
//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
