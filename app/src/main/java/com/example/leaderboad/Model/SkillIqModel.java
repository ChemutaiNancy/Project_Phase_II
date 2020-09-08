package com.example.leaderboad.Model;

public class SkillIqModel {

    int skillImage;
    String skillIqName;
    String skillIq;

    public SkillIqModel(int skillImage, String skillIqName, String skillIq) {
        this.skillImage = skillImage;
        this.skillIqName = skillIqName;
        this.skillIq = skillIq;
    }


    public int getSkillImage() {
        return skillImage;
    }

    public void setSkillImage(int skillImage) {
        this.skillImage = skillImage;
    }

    public String getSkillIqName() {
        return skillIqName;
    }

    public void setSkillIqName(String skillIqName) {
        this.skillIqName = skillIqName;
    }

    public String getSkillIq() {
        return skillIq;
    }

    public void setSkillIq(String skillIq) {
        this.skillIq = skillIq;
    }
}
