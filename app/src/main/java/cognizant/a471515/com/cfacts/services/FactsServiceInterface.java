package cognizant.a471515.com.cfacts.services;

import cognizant.a471515.com.cfacts.models.FactsCanadaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FactsServiceInterface {

    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<FactsCanadaResponse> getFactsList();

}
