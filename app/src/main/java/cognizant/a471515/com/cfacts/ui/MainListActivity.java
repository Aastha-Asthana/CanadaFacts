package cognizant.a471515.com.cfacts.ui;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import cognizant.a471515.com.cfacts.R;
import cognizant.a471515.com.cfacts.models.FactsResponseRow;

public class MainListActivity extends AppCompatActivity implements FactsUIInterface {

    private FactsPresenter presenter;
    private RecyclerView recyclerView;
    private FactsRecyclerAdapter recyclerAdapter;
    private ProgressBar progress;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView errorImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        initialize();
        presenter.getFactsCanadaResponse();
    }

    /**
     * This method is used to initialize the views of the layout
     */
    private void initialize(){
        presenter = new FactsPresenterImpl(this);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeContainer);
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorCanadaRed)));
        recyclerView = findViewById(R.id.facts_recycler_liew);
        recyclerAdapter = new FactsRecyclerAdapter( this);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.item_decorator));
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        errorImage = (ImageView)findViewById(R.id.error_image);
        progress = (ProgressBar)findViewById(R.id.progressBar_cyclic);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    /**
     *This method is used to update the UI after receiving the data from the service call.
     * @param factsCanadaRowList - List of facts that comes in the response of service call.
     */
    @Override
    public void updateUI(List<FactsResponseRow> factsCanadaRowList) {
        errorImage.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
        if(factsCanadaRowList.size() > 0) {
            recyclerAdapter.getDataList(factsCanadaRowList);
            recyclerView.setAdapter(recyclerAdapter);
        }else{
            showNoDataUpdatedMessage();
        }
    }

    /**
     *This method is used to show the loader while the service call is going on.
     */
    @Override
    public void showSpinner() {
        progress = new ProgressBar(MainListActivity.this);
        progress.setVisibility(View.VISIBLE);
    }

    /**
     * This method is used to hide the loader after the service call is completed
     */
    @Override
    public void hideSpinner() {
            progress.setVisibility(View.GONE);
    }

    /**
     * This method is used to change the action bar title depending on the title received from the service call response
     * @param title
     */
    @Override
    public void updateActionBar(String title) {
        getSupportActionBar().setTitle(title);
    }

    /**
     * This method is used to notify user that we did not receive any data from the service call via snackbar
     */
    @Override
    public void showNoDataUpdatedMessage() {
        Snackbar noUpdateMessage = Snackbar.make(swipeRefreshLayout,getString(R.string.no_data_found),Snackbar.LENGTH_LONG);
        noUpdateMessage.show();
    }

    /**
     * This method is used to notify user that service call was not successful via snackbar
     */
    @Override
    public void showErrorMessage() {
        Snackbar noUpdateMessage = Snackbar.make(swipeRefreshLayout,getString(R.string.error_message),Snackbar.LENGTH_LONG);
        noUpdateMessage.show();
    }

    /**
     * This method is used to notify user that there is no internet connection via snackbar
     */
    @Override
    public void showNoInternetConnectionMessage() {
        Snackbar noUpdateMessage = Snackbar.make(swipeRefreshLayout,getString(R.string.no_internet_connecion_message),Snackbar.LENGTH_LONG);
        noUpdateMessage.show();
    }

    @Override
    public void showErrorImage() {
        progress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        errorImage.setVisibility(View.VISIBLE);
    }

    /**
     * This listener is called after a successful swipe of the swipe layout
     */
    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            presenter.setSwipeToRefresh(true);
            presenter.getFactsCanadaResponse();
        }
    };

}
