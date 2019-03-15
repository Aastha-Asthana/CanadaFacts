package cognizant.a471515.com.cfacts.ui;

import java.util.List;

import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import cognizant.a471515.com.cfacts.models.FactsResponseRow;

public interface FactsPresenter {

    void getFactsResponse();
    void setSwipeToRefresh(boolean value);
    List<FactsResponseRow> getFactsList(FactsResponse factsResponse);
}
