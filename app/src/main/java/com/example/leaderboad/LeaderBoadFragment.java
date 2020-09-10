package com.example.leaderboad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leaderboad.Adapter.LeaderBoadAdapter;
import com.example.leaderboad.Adapter.SkillIqAdapter;
import com.example.leaderboad.Api.ApiClient;
import com.example.leaderboad.Model.LeaderboadModel;
import com.example.leaderboad.Model.SkillIqModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        leaderBoadAdapter = new LeaderBoadAdapter();
        getLeaderDetails();
        return view;
    }

    public void getLeaderDetails(){
        Call<List<LeaderboadModel>> leaderlist = ApiClient.getLeaders().getLeadersDetails();
        leaderlist.enqueue( new Callback<List<LeaderboadModel>>() {
            @Override
            public void onResponse(Call<List<LeaderboadModel>> call, Response<List<LeaderboadModel>> response) {
                if (response.isSuccessful()){
                    List<LeaderboadModel> leaderboadModelList = response.body();
                    leaderBoadAdapter.setLeaderboadDetails(leaderboadModelList);
                    recyclerView.setAdapter(leaderBoadAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<LeaderboadModel>> call, Throwable t) {
                Log.e( "Failure", "onFailure: " + t.getLocalizedMessage());
            }
        } );
    }

}
//    Fetching data via a simple API request with Retrofit