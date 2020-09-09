package com.example.leaderboad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.leaderboad.Adapter.LeaderBoadAdapter;
import com.example.leaderboad.Model.LeaderboadModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;


public class LeaderBoadFragment extends Fragment {

    String URL_GET_LEADERS_HOURS = "https://gadsapi.herokuapp.com/api/hours";
    RecyclerView recyclerView;
    LeaderBoadAdapter leaderBoadAdapter;
    List<LeaderboadModel> leaderboadModelList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_leader_boad, container, false );
        recyclerView = view.findViewById( R.id.leaderboadRecyclerview );
        recyclerView.setHasFixedSize( true );
//        leaderBoadAdapter = new LeaderBoadAdapter();
//        recyclerView.setAdapter(leaderBoadAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        recyclerView.setLayoutManager( layoutManager );

        leaderboadModelList = new ArrayList<>();

        loadLeaderHours();

        return view;
    }

    private void loadLeaderHours() {
        StringRequest stringRequest = new StringRequest( Request.Method.GET, URL_GET_LEADERS_HOURS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray( response );

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject( i );

                                LeaderboadModel leaderboadModel = new LeaderboadModel(
                                        obj.getInt( "image" ),
                                        obj.getString( "name" ),
                                        obj.getString( "hours" )
                                );

                                leaderboadModelList.add( leaderboadModel );
                            }

                            leaderBoadAdapter = new LeaderBoadAdapter( leaderboadModelList.getSupportFragmentManager() );
                            recyclerView.setAdapter( leaderBoadAdapter );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } );
        RequestQueue requestQueue = Volley.newRequestQueue( getContext() );
        requestQueue.add( stringRequest );
    }
}
//    Fetching data via a simple API request with Retrofit