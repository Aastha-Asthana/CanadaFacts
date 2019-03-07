package cognizant.a471515.com.cfacts.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsCanadaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactsServiceClass {

    private FactsServiceInterface factsServiceInterface;


    public void getCanadaFactsList(final APIResponseListener listener, final Context context){
        factsServiceInterface = ApiClient.getClient().create(FactsServiceInterface.class);

        Call<FactsCanadaResponse> call = factsServiceInterface.getFactsList();
        call.enqueue(new Callback<FactsCanadaResponse>() {
            @Override
            public void onResponse(Call<FactsCanadaResponse> call, Response<FactsCanadaResponse> response) {
                Log.d("Retrofit",response.toString());
                listener.onSuccess(response);
                Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FactsCanadaResponse> call, Throwable t) {
                listener.onError();
            }
        });

    }
}
