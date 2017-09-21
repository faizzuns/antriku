
package com.example.user.qroom.DataModel.Person;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonModel {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("dataset")
    @Expose
    private List<Dataset> dataset = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Dataset> getDataset() {
        return dataset;
    }

    public void setDataset(List<Dataset> dataset) {
        this.dataset = dataset;
    }

}
