package cognizant.a471515.com.cfacts;

import java.util.List;

import cognizant.a471515.com.cfacts.models.FactsCanadaRow;

public interface UIInterface {

    void updateUI(List<FactsCanadaRow> factsCanadaRowList);
    void showPullToRefreshLoader();
    void showSpinner();
    void hideSpinner();

}
