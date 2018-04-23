package com.muhaiminurabir.retrofitexample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllGroup {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("group_name")
    @Expose
    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}