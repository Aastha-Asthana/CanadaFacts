package cognizant.a471515.com.cfacts.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FactsResponse implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("rows")
    private List<FactsResponseRow> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FactsResponseRow> getRow() {
        return rows;
    }

    public void setRow(List<FactsResponseRow> rows) {
        this.rows = rows;
    }


}
