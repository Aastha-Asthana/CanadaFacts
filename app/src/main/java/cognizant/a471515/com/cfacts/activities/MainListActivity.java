package cognizant.a471515.com.cfacts.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import cognizant.a471515.com.cfacts.FactsPresenter;
import cognizant.a471515.com.cfacts.FactsPresenterImpl;
import cognizant.a471515.com.cfacts.FactsRecyclerAdapter;
import cognizant.a471515.com.cfacts.R;
import cognizant.a471515.com.cfacts.UIInterface;
import cognizant.a471515.com.cfacts.models.FactsCanadaResponse;
import cognizant.a471515.com.cfacts.models.FactsCanadaRow;
import cognizant.a471515.com.cfacts.services.ApiClient;
import cognizant.a471515.com.cfacts.services.FactsServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainListActivity extends AppCompatActivity implements UIInterface {

    private FactsPresenter presenter;
    private RecyclerView recyclerView;
    private FactsRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new FactsPresenterImpl(this);
        setContentView(R.layout.activity_main_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getFactsCanadaResponse();
    }


    @Override
    public void updateUI(List<FactsCanadaRow> factsCanadaRowList) {
        recyclerView = findViewById(R.id.facts_recycler_liew);
        recyclerAdapter = new FactsRecyclerAdapter(factsCanadaRowList);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void showPullToRefreshLoader() {

    }

    @Override
    public void showSpinner() {

    }

    @Override
    public void hideSpinner() {

    }
}
