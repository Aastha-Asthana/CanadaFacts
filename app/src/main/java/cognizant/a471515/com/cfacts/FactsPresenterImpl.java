package cognizant.a471515.com.cfacts;

import java.util.List;

import cognizant.a471515.com.cfacts.interactor.FactsServiceInteractor;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsCanadaResponse;
import cognizant.a471515.com.cfacts.models.FactsCanadaRow;
import cognizant.a471515.com.cfacts.services.FactsServiceClass;

public class FactsPresenterImpl implements FactsPresenter {

    private UIInterface factsUiInterface;
    private FactsServiceInteractor factsServiceInteractor = new FactsServiceClass();

    public FactsPresenterImpl(UIInterface uiInterface){
        factsUiInterface = uiInterface;
    }

    @Override
    public void getFactsCanadaResponse() {
        factsUiInterface.showSpinner();
        factsServiceInteractor.getFactsList(new APIResponseListener() {
            @Override
            public void onSuccess(Object dataObject) {
                factsUiInterface.hideSpinner();
                factsUiInterface.updateUI(getFactsList((FactsCanadaResponse) dataObject));
            }

            @Override
            public void onError() {
                factsUiInterface.hideSpinner();
            }
        });
    }

    private List<FactsCanadaRow> getFactsList(FactsCanadaResponse factsCanadaResponse){
        return factsCanadaResponse.getRow();
    }
}
