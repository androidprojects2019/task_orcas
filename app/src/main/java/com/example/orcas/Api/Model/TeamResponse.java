package com.example.orcas.Api.Model;

import java.util.List;
 import com.google.gson.annotations.SerializedName;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Entity()
public class TeamResponse{

 	@Ignore
	@SerializedName("area")
	private Area area;

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

	@TypeConverters(Converter.class)
	@ColumnInfo()
   	@SerializedName("squad")
	private List<SquadItem> squad;

	@ColumnInfo()
	@SerializedName("phone")
	private String phone;

	@ColumnInfo()
	@SerializedName("name")
	private String name;

	@Ignore()
	@SerializedName("activeCompetitions")
	private List<ActiveCompetitionsItem> activeCompetitions;

	@PrimaryKey(autoGenerate = true)
	@SerializedName("id")
	private int id;

	@ColumnInfo()
	@SerializedName("shortName")
	private String shortName;

	public TeamResponse() {
	}

	@ColumnInfo()
	@SerializedName("email")
	private String email;

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return area;
	}

	public void setVenue(String venue){
		this.venue = venue;
	}

	public String getVenue(){
		return venue;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCrestUrl(String crestUrl){
		this.crestUrl = crestUrl;
	}

	public String getCrestUrl(){
		return crestUrl;
	}

	public void setTla(String tla){
		this.tla = tla;
	}

	public String getTla(){
		return tla;
	}

	public void setFounded(int founded){
		this.founded = founded;
	}

	public int getFounded(){
		return founded;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setClubColors(String clubColors){
		this.clubColors = clubColors;
	}

	public String getClubColors(){
		return clubColors;
	}

	public void setSquad(List<SquadItem> squad){
		this.squad = squad;
	}

	public List<SquadItem> getSquad(){
		return squad;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActiveCompetitions(List<ActiveCompetitionsItem> activeCompetitions){
		this.activeCompetitions = activeCompetitions;
	}

	public List<ActiveCompetitionsItem> getActiveCompetitions(){
		return activeCompetitions;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"TeamResponse{" + 
			"area = '" + area + '\'' + 
			",venue = '" + venue + '\'' + 
			",website = '" + website + '\'' + 
			",address = '" + address + '\'' + 
			",crestUrl = '" + crestUrl + '\'' + 
			",tla = '" + tla + '\'' + 
			",founded = '" + founded + '\'' + 
			",lastUpdated = '" + lastUpdated + '\'' + 
			",clubColors = '" + clubColors + '\'' + 
			",squad = '" + squad + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",activeCompetitions = '" + activeCompetitions + '\'' + 
			",id = '" + id + '\'' + 
			",shortName = '" + shortName + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}