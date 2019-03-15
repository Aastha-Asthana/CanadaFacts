package cognizant.a471515.com.cfacts.ui;

import java.net.UnknownHostException;
import java.util.List;

import cognizant.a471515.com.cfacts.services.FactsServiceInteractor;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import cognizant.a471515.com.cfacts.models.FactsResponseRow;
import cognizant.a471515.com.cfacts.services.FactsServiceClass;

public class FactsPresenterImpl implements FactsPresenter {

    private FactsView factsView;
    private FactsServiceInteractor factsServiceInteractor = new FactsServiceClass();
    private boolean isSwipeToRefresh = false;

    public FactsPresenterImpl(FactsView factsView){
        this.factsView = factsView;
    }

    @Override
    public void getFactsResponse() {
        if(!isSwipeToRefresh)
        factsView.showSpinner();
        factsServiceInteractor.getFactsList(new APIResponseListener() {
            @Override
            public void onSuccess(Object dataObject) {
                if(!isSwipeToRefresh)
                factsView.hideSpinner();
                factsView.updateUI(getFactsList((FactsResponse) dataObject));
                factsView.updateActionBar(((FactsResponse) dataObject).getTitle());
            }

            @Override
            public void onError(Object errorObject) {
                factsView.hideSpinner();
                factsView.showErrorImage();
                if(isSwipeToRefresh){
                    factsView.showNoDataUpdatedMessage();
                    isSwipeToRefresh = false;
                }else{
                    if(errorObject instanceof UnknownHostException){
                        factsView.showNoInternetConnectionMessage();
                    }else{
                       factsView.showErrorMessage();
                    }
                    factsView.hideSpinner();
                }
            }
        });
    }

    @Override
    public void setSwipeToRefresh(boolean value) {
        isSwipeToRefresh = value;
    }

    @Override
    public List<FactsResponseRow> getFactsList(FactsResponse factsResponse){
        return factsResponse.getRow();
    }
}
