package com.example.orcas.Api.Model;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TeamsItem {

    @SerializedName("isFavourite")
    @ColumnInfo
    boolean isFavourite;
    @ColumnInfo()
    @SerializedName("venue")
    private String venue;

    @ColumnInfo()

    @SerializedName("website")
    private String website;

    @ColumnInfo()

    @SerializedName("address")
    private String address;

    @ColumnInfo()

    @SerializedName("crestUrl")
    private String crestUrl;

    @ColumnInfo()

    @SerializedName("tla")
    private String tla;

    @ColumnInfo()

    @SerializedName("founded")
    private int founded;

    @ColumnInfo()

    @SerializedName("lastUpdated")
    private String lastUpdated;

    @ColumnInfo()

    @SerializedName("clubColors")
    private String clubColors;

    @ColumnInfo()

    @SerializedName("phone")
    private String phone;

    @ColumnInfo()

    @SerializedName("name")
    private String name;

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;

    @ColumnInfo()

    @SerializedName("shortName")
    private String shortName;
    @ColumnInfo()

    @SerializedName("email")
    private String email;

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getVenue() {
        return venue;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getTla() {
        return tla;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public int getFounded() {
        return founded;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public TeamsItem() {
    }

    @Override
    public String toString() {
        return
                "TeamsItem{" +
                        ",venue = '" + venue + '\'' +
                        ",website = '" + website + '\'' +
                        ",address = '" + address + '\'' +
                        ",crestUrl = '" + crestUrl + '\'' +
                        ",tla = '" + tla + '\'' +
                        ",founded = '" + founded + '\'' +
                        ",lastUpdated = '" + lastUpdated + '\'' +
                        ",clubColors = '" + clubColors + '\'' +
                        ",phone = '" + phone + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",shortName = '" + shortName + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}