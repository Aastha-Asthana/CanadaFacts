package cognizant.a471515.com.cfacts.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import cognizant.a471515.com.cfacts.interactor.FactsServiceInteractor;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsCanadaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactsServiceClass implements FactsServiceInteractor {

    private FactsServiceInterface factsServiceInterface;

    @Override
    public void getFactsList(final APIResponseListener listener) {
        factsServiceInterface = ApiClient.getClient().create(FactsServiceInterface.class);

        Call<FactsCanadaResponse> call = factsServiceInterface.getFactsList();
        call.enqueue(new Callback<FactsCanadaResponse>() {
            @Override
            public void onResponse(Call<FactsCanadaResponse> call, Response<FactsCanadaResponse> response) {
                Log.d("Retrofit",response.toString());
                if(response.isSuccessful() && response.body() != null){
                    FactsCanadaResponse factsCanadaResponse = response.body();
                    listener.onSuccess(factsCanadaResponse);
                }else{
                    listener.onError();
                }

            }

            @Override
            public void onFailure(Call<FactsCanadaResponse> call, Throwable t) {
                listener.onError();
            }
        });
    }

}
