package com.example.leaderboad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leaderboad.Adapter.LeaderBoadAdapter;
import com.example.leaderboad.Api.ApiClient;
import com.example.leaderboad.Model.LeaderboadModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LeaderBoadFragment extends Fragment {


    RecyclerView recyclerView;
    LeaderBoadAdapter leaderBoadAdapter;
//    List<LeaderboadModel> leaderboadModelList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_leader_boad, container, false );
        recyclerView = view.findViewById(R.id.leaderboadRecyclerview);
        recyclerView.setHasFixedSize( true );
        leaderBoadAdapter = new LeaderBoadAdapter();
        recyclerView.setAdapter(leaderBoadAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );

        Call<List<LeaderboadModel>> leaderlist = ApiClient.getLeaders().getLeadersDetails();
        leaderlist.enqueue( new Callback<List<LeaderboadModel>>() {
            @Override
            public void onResponse(Call<List<LeaderboadModel>> call, Response<List<LeaderboadModel>> response) {
                if (response.isSuccessful()){
                    Log.e( "Success", "onResponse: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<LeaderboadModel>> call, Throwable t) {
                Log.e( "Failure", "onFailure: " + t.getLocalizedMessage());
            }
        } );


        return view;
    }


}
//    Fetching data via a simple API request with Retrofit