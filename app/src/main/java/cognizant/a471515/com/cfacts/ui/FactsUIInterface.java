package cognizant.a471515.com.cfacts.ui;

import java.util.List;

import cognizant.a471515.com.cfacts.models.FactsResponseRow;

public interface FactsUIInterface {

    void updateUI(List<FactsResponseRow> factsCanadaRowList);
    void showSpinner();
    void hideSpinner();
    void updateActionBar(String title);
    void showNoDataUpdatedMessage();
    void showErrorMessage();
    void showNoInternetConnectionMessage();
    void showErrorImage();

}
