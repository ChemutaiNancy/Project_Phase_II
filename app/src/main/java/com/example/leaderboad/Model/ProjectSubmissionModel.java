package com.example.leaderboad.Model;

public class ProjectSubmissionModel {

    String firstname;
    String lastname;
    String email;
    String link;

    public ProjectSubmissionModel(String firstname, String lastname, String email, String link) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.link = link;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

     public String getEmail() {
        return email;
    }

    public String getLink() {
        return link;
    }
}
