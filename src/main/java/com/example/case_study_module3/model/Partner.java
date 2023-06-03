package com.example.case_study_module3.model;

import java.time.LocalDate;
import java.util.List;

public class Partner {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private double hourlyRate;
    private int availability;
    private byte[] image;
    private LocalDate dob;
    private String address;
    private int gender;
    private List<Options> optionsList;

    public Partner() {
    }

    public Partner(int id, String username, String password, String nickname,
                   double hourlyRate, int availability, byte[] image, LocalDate dob,
                   String address, int gender, List<Options> optionsList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.hourlyRate = hourlyRate;
        this.availability = availability;
        this.image = image;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.optionsList = optionsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }
}
