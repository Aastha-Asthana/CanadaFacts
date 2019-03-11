package cognizant.a471515.com.cfacts.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FactsResponse implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("rows")
    private List<FactsCanadaRow> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FactsCanadaRow> getRow() {
        return rows;
    }

    public void setRow(List<FactsCanadaRow> rows) {
        this.rows = rows;
    }


}
