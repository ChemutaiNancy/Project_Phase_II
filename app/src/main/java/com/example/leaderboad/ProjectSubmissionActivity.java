package com.example.leaderboad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.leaderboad.Api.ProjectSubmissionApi;
import com.example.leaderboad.Model.ProjectSubmissionModel;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class ProjectSubmissionActivity extends AppCompatActivity {

    TextInputEditText firstName, lastName, email, projectLink;
    Button btnSubmit;

    private ProjectSubmissionApi projectSubmissionApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.project_submission);

        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        email = findViewById(R.id.etEmail);
        projectLink = findViewById(R.id.etGitHubLink);
        btnSubmit = findViewById(R.id.btnSubmit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1z\n"+
                        "l35cwZr2xyjIhaMAz8WChQ/formResponse")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        projectSubmissionApi = retrofit.create(ProjectSubmissionApi.class);



        btnSubmit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitProject();

                if (view.isSaveEnabled())
                    openConfirmationDialog();
            }
        } );
    }

    private void submitProject() {

        Call<POST> submitProject = projectSubmissionApi.submitProject("First Name", "Last Name", "Email", "GitHub Link");
        submitProject.enqueue( new Callback<POST>() {
            @Override
            public void onResponse(Call<POST> call, Response<POST> response) {
                if (!response.isSuccessful()){
                    Toast.makeText( ProjectSubmissionActivity.this, response.code(), Toast.LENGTH_SHORT ).show();
                    return;
                }

                ProjectSubmissionModel submitResponse = (ProjectSubmissionModel) response.body();

                String firstname = "First Name:" + submitResponse.getFirstname() + "\n";
                String lastname = "Last Name:" + submitResponse.getLastname() + "\n";
                String emailadd = "Email Address" + submitResponse.getEmail() + "\n";
                String link = "GitHub Link" + submitResponse.getLink() + "\n";

                firstName.setText(firstname);
                lastName.setText(lastname);
                email.setText(emailadd);
                projectLink.setText(link);
            }

            @Override
            public void onFailure(Call<POST> call, Throwable t) {
                Toast.makeText( ProjectSubmissionActivity.this, t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );
    }

    private void openConfirmationDialog() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog();
        confirmationDialog.show(getSupportFragmentManager(), "");
    }

}
