package cognizant.a471515.com.cfacts.services;

import android.util.Log;

import cognizant.a471515.com.cfacts.FactsApp;
import cognizant.a471515.com.cfacts.R;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactsServiceClass implements FactsServiceInteractor {

    private FactsServiceInterface factsServiceInterface;

    @Override
    public void getFactsList(final APIResponseListener listener) {
            factsServiceInterface = ApiClient.getClient().create(FactsServiceInterface.class);
            Call<FactsResponse> call = factsServiceInterface.getFactsList();
            call.enqueue(new Callback<FactsResponse>() {
                @Override
                public void onResponse(Call<FactsResponse> call, Response<FactsResponse> response) {
                    Log.d(FactsApp.context.getResources().getString(R.string.retrofit), response.toString());
                    if (null != response && response.isSuccessful() && response.body() != null && response.code() == 200) {
                        FactsResponse factsResponse = response.body();
                        listener.onSuccess(factsResponse);
                    } else {
                        listener.onError(response.body());
                    }

                }

                @Override
                public void onFailure(Call<FactsResponse> call, Throwable t) {
                    listener.onError(t);
                }
            });

        }

}
