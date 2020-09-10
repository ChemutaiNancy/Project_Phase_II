package com.example.leaderboad.Api;

import com.example.leaderboad.Model.SkillIqModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSkillService {

    @GET("/api/skilliq")
    Call<List<SkillIqModel>> getSkillIqDetails();
}
