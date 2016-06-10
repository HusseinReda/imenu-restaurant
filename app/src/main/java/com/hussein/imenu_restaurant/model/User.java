package com.hussein.imenu_restaurant.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hussein Abu Maash on 3/10/2016.
 */

public class User implements Serializable {
    private long id;
    private String name;
    private String email;
    private String password;
    private String gender; //Male or Female
    private Date dateOfBirth;
    private Date joinDate;
    private String country;
    private String city;
    private String picture;
    private byte[] image;
    //////
    private ArrayList<String> preferences;
    private List<UserSpec> healthIssues;
    private List<UserSpec> restrictions;

    private int state;
    /*
    1 -> not connected
    2 -> connected
    3 -> ordered
     */

    public User() {
    }

    public User(String name, String email, String password, String gender, Date dateOfBirth, String country, String city, int state) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.city = city;
        this.state = state;
    }

    public User(String name, String email, String password, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.preferences=new ArrayList<String>();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<String> preferences) {
        this.preferences = preferences;
    }

    public List<UserSpec> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(ArrayList<UserSpec> healthIssues) {
        this.healthIssues = healthIssues;
    }

    public List<UserSpec> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<UserSpec> restrictions) {
        this.restrictions = restrictions;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    //    public void addPreference(String preference){
//        PreferenceService addPreferenceService = new PreferenceService(getEmail(),preference,"add");
//        if(addPreferenceService.getResult())
//            getPreferences().add(preference);
//    }

    public boolean findPreference(String preference){
        return getPreferences().indexOf(preference) != -1;
    }

//    public void removePreference(String preference){
//        int exist = getPreferences().indexOf(preference);
//        if(exist!=-1) {
//            PreferenceService removePreferenceService = new PreferenceService(getEmail(),preference,"remove");
//            if(removePreferenceService.getResult())
//                getPreferences().remove(preference);
//        }
//    }

//    public void addHealthIssue(UserSpec healthIssue){
//        HealthIssueService addHealthIssueService = new HealthIssueService(getId(),healthIssue,"add");
//        if(addHealthIssueService.getResult().equals("OK"))
//            getHealthIssues().add(healthIssue);
//    }
//
//    public void removeHealthIssue(String healthIssueName){
//        List<UserSpec> healthIssues = getHealthIssues();
//        UserSpec healthIssue;
//        for(int i=0;i<healthIssues.size();i++){
//            if(healthIssues.get(i).getName().equals(healthIssueName)) {
//                healthIssue = healthIssues.get(i);
//                HealthIssueService removeHealthIssueService = new HealthIssueService(getId(),healthIssue,"remove");
//                if(removeHealthIssueService.getResult().equals("OK"))
//                    getHealthIssues().remove(healthIssue);
//                break;
//            }
//        }
//    }
//
//    //to be implemented
//    public void addRestriction(UserSpec restriction){
//        RestrictionService addRestrictionService = new RestrictionService(getId(),restriction,"add");
//        if(addRestrictionService.getResult().equals("OK"))
//            getRestrictions().add(restriction);
//    }

    //to be implemented
//    public void removeRestriction(String restrictionName){
//        List<UserSpec> restrictions = getRestrictions();
//        UserSpec restriction;
//        for(int i=0;i<restrictions.size();i++){
//            if(restrictions.get(i).getName().equals(restrictionName)) {
//                restriction = restrictions.get(i);
//                RestrictionService removeRestrictionService = new RestrictionService(getId(), restriction,"remove");
//                if(removeRestrictionService.getResult().equals("OK"))
//                    getHealthIssues().remove(restriction);
//                break;
//            }
//        }
//    }

    //to be implemented
    public String isHazardous(String keyword){
        for(int i=0;i<getHealthIssues().size();i++){
            if(getHealthIssues().get(i).getName().equals(keyword)) {
                return getHealthIssues().get(i).getNote();
            }
        }
        return "safe";
    }

    //to be implemented
    public String isProhibited(String keyword){
        for(int i=0;i<getRestrictions().size();i++){
            if(getRestrictions().get(i).getName().equals(keyword)) {
                return getRestrictions().get(i).getNote();
            }
        }
        return "safe";
    }

    public void copyUser(User user) {
        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.password = user.password;
        this.gender = user.gender;
        this.dateOfBirth = user.dateOfBirth;
        this.joinDate = user.joinDate;
        this.country = user.country;
        this.city = user.city;
        this.picture = user.picture;
        this.preferences = user.preferences;
        this.healthIssues = user.healthIssues;
        this.restrictions = user.restrictions;
        this.image = user.image;
    }

    public boolean findRestrictionByName(String name){
        for(int i=0;i<restrictions.size();i++){
            if(restrictions.get(i).getName().equals(name))
                return true;
        }
        return false;
    }
    public boolean findHealthIssueByName(String name){
        for(int i=0;i<healthIssues.size();i++){
            if(healthIssues.get(i).getName().equals(name))
                return true;
        }
        return false;
    }

    public void removeRestrictionByName(String name){
        for(int i=0;i<restrictions.size();i++){
            if(restrictions.get(i).getName().equals(name)){
                restrictions.remove(i);
                return;
            }
        }
    }

    public void removeHealthIssueByName(String name){
        for(int i=0;i<healthIssues.size();i++){
            if(healthIssues.get(i).getName().equals(name)){
                healthIssues.remove(i);
                return;
            }
        }
    }

}
