package ru.mikhalev.vladimir.gotfamilies.data.network;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CharacterModelResponse {

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("culture")
    @Expose
    public String culture;
    @SerializedName("born")
    @Expose
    public String born;
    @SerializedName("died")
    @Expose
    public String died;
    @SerializedName("titles")
    @Expose
    public List<Object> titles = new ArrayList<Object>();
    @SerializedName("aliases")
    @Expose
    public List<String> aliases = new ArrayList<String>();
    @SerializedName("father")
    @Expose
    public String father;
    @SerializedName("mother")
    @Expose
    public String mother;
    @SerializedName("spouse")
    @Expose
    public String spouse;
    @SerializedName("allegiances")
    @Expose
    public List<String> allegiances = new ArrayList<String>();
    @SerializedName("books")
    @Expose
    public List<String> books = new ArrayList<String>();
    @SerializedName("povBooks")
    @Expose
    public List<Object> povBooks = new ArrayList<Object>();
    @SerializedName("tvSeries")
    @Expose
    public List<String> tvSeries = new ArrayList<String>();
    @SerializedName("playedBy")
    @Expose
    public List<String> playedBy = new ArrayList<String>();

}
