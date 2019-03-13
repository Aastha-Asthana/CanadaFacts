package cognizant.a471515.com.cfacts.services;

import cognizant.a471515.com.cfacts.Facts;
import cognizant.a471515.com.cfacts.FactsUtils;
import cognizant.a471515.com.cfacts.R;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if(FactsUtils.isOfflineMode) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new OfflineMockInterceptor())
                .build();

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Facts.context.getResources().getString(R.string.base_url))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        }else {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Facts.context.getResources().getString(R.string.base_url))
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

}
