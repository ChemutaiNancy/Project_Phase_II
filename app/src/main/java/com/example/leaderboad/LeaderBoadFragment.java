package com.example.leaderboad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leaderboad.Adapter.LeaderBoadAdapter;


public class LeaderBoadFragment extends Fragment {

    RecyclerView recyclerView;
    LeaderBoadAdapter leaderBoadAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_leader_boad, container, false );
        recyclerView = view.findViewById(R.id.leaderboadRecyclerview);
        leaderBoadAdapter = new LeaderBoadAdapter();
        recyclerView.setAdapter(leaderBoadAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}