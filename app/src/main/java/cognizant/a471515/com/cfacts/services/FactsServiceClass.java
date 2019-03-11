package cognizant.a471515.com.cfacts.services;

import android.util.Log;

import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactsServiceClass implements FactsServiceInteractor {

    private FactsServiceInterface factsServiceInterface;
    private int counter = 0;

    @Override
    public void getFactsList(final APIResponseListener listener) {
            factsServiceInterface = ApiClient.getClient().create(FactsServiceInterface.class);
            Call<FactsResponse> call = factsServiceInterface.getFactsList();
            call.enqueue(new Callback<FactsResponse>() {
                @Override
                public void onResponse(Call<FactsResponse> call, Response<FactsResponse> response) {
                    Log.d("Retrofit", response.toString());
                    if (null != response && response.isSuccessful() && response.body() != null) {
                        FactsResponse factsResponse = response.body();
                        listener.onSuccess(factsResponse);
                    } else {
                        listener.onError();
                    }

                }

                @Override
                public void onFailure(Call<FactsResponse> call, Throwable t) {
                    listener.onError();
                }
            });

        }

}
