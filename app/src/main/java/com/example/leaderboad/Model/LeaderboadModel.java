package com.example.leaderboad.Model;

public class LeaderboadModel {

    int leaderboadImage;
    String leaderboadName;
    String leaderboadHour;

    public LeaderboadModel(int leaderboadImage, String leaderboadName, String leaderboadHour) {
        this.leaderboadImage = leaderboadImage;
        this.leaderboadName = leaderboadName;
        this.leaderboadHour = leaderboadHour;
    }

    public int getLeaderboadImage() {
        return leaderboadImage;
    }

    public void setLeaderboadImage(int leaderboadImage) {
        this.leaderboadImage = leaderboadImage;
    }

    public String getLeaderboadName() {
        return leaderboadName;
    }

    public void setLeaderboadName(String leaderboadName) {
        this.leaderboadName = leaderboadName;
    }

    public String getLeaderboadHour() {
        return leaderboadHour;
    }

    public void setLeaderboadHour(String leaderboadHour) {
        this.leaderboadHour = leaderboadHour;
    }
}
