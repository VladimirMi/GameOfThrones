package ru.mikhalev.vladimir.gotfamilies.data.network;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HouseModelResponse {
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("coatOfArms")
    @Expose
    public String coatOfArms;
    @SerializedName("words")
    @Expose
    public String words;
    @SerializedName("titles")
    @Expose
    public List<String> titles = new ArrayList<String>();
    @SerializedName("seats")
    @Expose
    public List<String> seats = new ArrayList<String>();
    @SerializedName("currentLord")
    @Expose
    public String currentLord;
    @SerializedName("heir")
    @Expose
    public String heir;
    @SerializedName("overlord")
    @Expose
    public String overlord;
    @SerializedName("founded")
    @Expose
    public String founded;
    @SerializedName("founder")
    @Expose
    public String founder;
    @SerializedName("diedOut")
    @Expose
    public String diedOut;
    @SerializedName("ancestralWeapons")
    @Expose
    public List<String> ancestralWeapons = new ArrayList<String>();
    @SerializedName("cadetBranches")
    @Expose
    public List<String> cadetBranches = new ArrayList<String>();
    @SerializedName("swornMembers")
    @Expose
    public List<String> swornMembers = new ArrayList<String>();


}
