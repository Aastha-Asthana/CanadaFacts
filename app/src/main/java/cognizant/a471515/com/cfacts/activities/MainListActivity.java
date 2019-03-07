package cognizant.a471515.com.cfacts.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cognizant.a471515.com.cfacts.R;
import cognizant.a471515.com.cfacts.models.FactsCanadaResponse;
import cognizant.a471515.com.cfacts.services.ApiClient;
import cognizant.a471515.com.cfacts.services.FactsServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);


    }
}
