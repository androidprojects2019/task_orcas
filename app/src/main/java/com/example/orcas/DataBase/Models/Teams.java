package com.example.orcas.DataBase.Models;

import com.example.orcas.Api.Model.Area;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Teams {
    @PrimaryKey(autoGenerate = false)
    int id;
    @ColumnInfo
    String name;
    @ColumnInfo
    String website;
    @ColumnInfo
    String clubColors;
    @ColumnInfo
    String venu;
    @ColumnInfo
    String address;
    @ColumnInfo
    String crestUrl;
    @ColumnInfo
    String tla;
    @ColumnInfo
    int founded;
    @ColumnInfo
    String lastUpdated;
    @ColumnInfo
    String phone;
    @ColumnInfo
    String shortName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getVenu() {
        return venu;
    }

    public void setVenu(String venu) {
        this.venu = venu;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Ignore
    public Teams(int id, String name, String website, String clubColors, String venu, Area area, String address, String crestUrl, String tla, int founded, String lastUpdated, String phone, String shortName, String email) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.clubColors = clubColors;
        this.venu = venu;
        this.address = address;
        this.crestUrl = crestUrl;
        this.tla = tla;
        this.founded = founded;
        this.lastUpdated = lastUpdated;
        this.phone = phone;
        this.shortName = shortName;
        this.email = email;
    }

    @ColumnInfo
    String email;

    public Teams() {
    }

}
