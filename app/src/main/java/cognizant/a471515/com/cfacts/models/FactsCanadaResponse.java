package cognizant.a471515.com.cfacts.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FactsCanadaResponse implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("row")
    private List<FactsCanadaRow> row;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FactsCanadaRow> getRow() {
        return row;
    }

    public void setRow(List<FactsCanadaRow> row) {
        this.row = row;
    }


}
