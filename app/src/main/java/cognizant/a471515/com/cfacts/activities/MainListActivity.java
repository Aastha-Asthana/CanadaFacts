package cognizant.a471515.com.cfacts.activities;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import cognizant.a471515.com.cfacts.FactsPresenter;
import cognizant.a471515.com.cfacts.FactsPresenterImpl;
import cognizant.a471515.com.cfacts.FactsRecyclerAdapter;
import cognizant.a471515.com.cfacts.R;
import cognizant.a471515.com.cfacts.UIInterface;
import cognizant.a471515.com.cfacts.models.FactsCanadaRow;

public class MainListActivity extends AppCompatActivity implements UIInterface {

    private FactsPresenter presenter;
    private RecyclerView recyclerView;
    private FactsRecyclerAdapter recyclerAdapter;
    private ProgressDialog progress;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new FactsPresenterImpl(this);
        setContentView(R.layout.activity_main_list);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeContainer);
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorCanadaRed)));
       // Fresco.initialize(this);
        presenter.getFactsCanadaResponse();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void updateUI(List<FactsCanadaRow> factsCanadaRowList) {
        swipeRefreshLayout.setRefreshing(false);
        recyclerView = findViewById(R.id.facts_recycler_liew);
        recyclerAdapter = new FactsRecyclerAdapter(factsCanadaRowList,this);
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.item_decorator));
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showPullToRefreshLoader() {

    }

    @Override
    public void showSpinner() {
        progress = new ProgressDialog(MainListActivity.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();


    }

    @Override
    public void hideSpinner() {
        if(progress != null && progress.isShowing()){
            progress.dismiss();
        }
    }

    @Override
    public void updateActionBar(String title) {
        getSupportActionBar().setTitle(title);
    }

    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            presenter.getFactsCanadaResponse();
        }
    };

    private List<FactsCanadaRow> getData() {

        FactsCanadaRow row1 = new FactsCanadaRow();
        FactsCanadaRow row2 = new FactsCanadaRow();
        FactsCanadaRow row3 = new FactsCanadaRow();

        row1.setTitle("Flag Color");
        row1.setImageHref(null);
        row1.setDescription("Flag color is red");

        row2.setTitle("Flag Color2");
        row2.setImageHref(null);
        row2.setDescription("Flag color is red");

        row3.setTitle("Flag Color3");
        row3.setImageHref(null);
        row3.setDescription("Flag color is red");

        List<FactsCanadaRow> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);

        return list;

    }
}
