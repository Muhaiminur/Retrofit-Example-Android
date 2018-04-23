package com.muhaiminurabir.retrofitexample.Model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Product_grps {
    @SerializedName("all_groups")
    @Expose
    private List<AllGroup> allGroups = null;

    public List<AllGroup> getAllGroups() {
        return allGroups;
    }

    public void setAllGroups(List<AllGroup> allGroups) {
        this.allGroups = allGroups;
    }
}
