package com.example.leaderboad;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.Adapter.SkillIqAdapter;
import com.example.leaderboad.Api.ApiClient;
import com.example.leaderboad.Model.SkillIqModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqFragment extends Fragment {

    RecyclerView recyclerView;
    SkillIqAdapter skillIqAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_iq, container, false);

        recyclerView = view.findViewById(R.id.skillRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        skillIqAdapter = new SkillIqAdapter();
        getSkillDetails();
        return view;
    }

    public void getSkillDetails(){
        Call<List<SkillIqModel>> skillList = ApiClient.getSkillIq().getSkillIqDetails();
        skillList.enqueue( new Callback<List<SkillIqModel>>() {
            @Override
            public void onResponse(Call<List<SkillIqModel>> call, Response<List<SkillIqModel>> response) {
                if (response.isSuccessful()){
                    List<SkillIqModel> skillIqModelList = response.body();
                    skillIqAdapter.setSkillData(skillIqModelList);
                    recyclerView.setAdapter(skillIqAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<SkillIqModel>> call, Throwable t) {
                Log.e( "Failure", "onFailure: " + t.getLocalizedMessage());
            }
        } );
    }
}
