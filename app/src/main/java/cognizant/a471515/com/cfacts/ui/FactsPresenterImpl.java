package cognizant.a471515.com.cfacts.ui;

import android.widget.Toast;

import java.util.List;

import cognizant.a471515.com.cfacts.services.FactsServiceInteractor;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import cognizant.a471515.com.cfacts.models.FactsCanadaRow;
import cognizant.a471515.com.cfacts.services.FactsServiceClass;

public class FactsPresenterImpl implements FactsPresenter {

    private FactsUIInterface factsUiInterface;
    private FactsServiceInteractor factsServiceInteractor = new FactsServiceClass();
    private boolean isSwipeToRefresh = false;

    public FactsPresenterImpl(FactsUIInterface factsUiInterface){
        this.factsUiInterface = factsUiInterface;
    }

    @Override
    public void getFactsCanadaResponse() {
        if(!isSwipeToRefresh)
        factsUiInterface.showSpinner();
        factsServiceInteractor.getFactsList(new APIResponseListener() {
            @Override
            public void onSuccess(Object dataObject) {
                if(!isSwipeToRefresh)
                factsUiInterface.hideSpinner();
                factsUiInterface.updateUI(getFactsList((FactsResponse) dataObject));
                factsUiInterface.updateActionBar(((FactsResponse) dataObject).getTitle());
            }

            @Override
            public void onError() {
                if(isSwipeToRefresh){
                    factsUiInterface.showNoDataUpdatedMessage();
                    isSwipeToRefresh = false;
                }else{
                    factsUiInterface.hideSpinner();
                }
            }
        });
    }

    @Override
    public void setSwipeToRefresh(boolean value) {
        isSwipeToRefresh = value;
    }

    private List<FactsCanadaRow> getFactsList(FactsResponse factsResponse){
        return factsResponse.getRow();
    }
}
