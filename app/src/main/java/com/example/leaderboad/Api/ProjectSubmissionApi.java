package com.example.leaderboad.Api;

import com.example.leaderboad.Model.ProjectSubmissionModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProjectSubmissionApi {

    @POST("posts")
    Call<POST> submitProject(@Body ProjectSubmissionModel projectSubmission);

    @FormUrlEncoded
    @POST("posts")
    Call<POST> submitProject(
            @Field("First Name") String firstName,
            @Field("Last Name") String lastName,
            @Field("Email Address") String email,
            @Field("Project GitHub (Link)") String link
    );
}
