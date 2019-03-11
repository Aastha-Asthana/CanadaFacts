package cognizant.a471515.com.cfacts.ui;

import java.util.List;

import cognizant.a471515.com.cfacts.models.FactsCanadaRow;

public interface FactsUIInterface {

    void updateUI(List<FactsCanadaRow> factsCanadaRowList);
    void showSpinner();
    void hideSpinner();
    void updateActionBar(String title);
    void showNoDataUpdatedMessage();

}
