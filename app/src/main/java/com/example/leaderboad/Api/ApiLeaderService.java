package com.example.leaderboad.Api;

import com.example.leaderboad.Model.LeaderboadModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiLeaderService {

    @GET("/api/hours")
    Call<List<LeaderboadModel>> getLeadersDetails();
}
