package cognizant.a471515.com.cfacts.services;

import cognizant.a471515.com.cfacts.models.FactsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FactsServiceInterface {

    @GET("/s/vg0eortkl/facts.json")
    Call<FactsResponse> getFactsList();

}
