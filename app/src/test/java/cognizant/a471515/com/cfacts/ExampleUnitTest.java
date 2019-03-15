package cognizant.a471515.com.cfacts;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import cognizant.a471515.com.cfacts.models.FactsResponseRow;
import cognizant.a471515.com.cfacts.services.FactsServiceClass;
import cognizant.a471515.com.cfacts.services.FactsServiceInteractor;
import cognizant.a471515.com.cfacts.ui.FactsPresenterImpl;
import cognizant.a471515.com.cfacts.adapter.FactsRecyclerAdapter;
import cognizant.a471515.com.cfacts.ui.FactsView;
import cognizant.a471515.com.cfacts.ui.MainListActivity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private FactsServiceInteractor serviceInteractor = new FactsServiceClass();
    FactsView uiInterface = new MainListActivity();

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkForAppendedString(){
        String testString = "1 . Fact";
        FactsUtils utils = new FactsUtils();
        assertEquals(testString,utils.getAppendedFactsPosition(1,"Fact"));
    }

    @Test
    public void checkServiceCall(){
        serviceInteractor.getFactsList(new APIResponseListener() {
            @Override
            public void onSuccess(Object dataObject) {
                assertNotNull(dataObject);
            }

            @Override
            public void onError(Object errorObject) {
                assertNotNull(errorObject);
            }
        });
    }

    @Test
    public void presenterTest1(){
        FactsPresenterImpl factsPresenter = new FactsPresenterImpl(uiInterface);
        List<FactsResponseRow> list = factsPresenter.getFactsList(getFacts());
        assertEquals(getFactsList().get(1).getTitle(),list.get(1).getTitle());

    }

    @Test
    public void presenterTest2(){
        FactsPresenterImpl mockpresenter = mock(FactsPresenterImpl.class);
        mockpresenter.getFactsResponse();


    }

    @Test
    public void adapterTest1(){
        FactsRecyclerAdapter adapter = new FactsRecyclerAdapter(FactsApp.context);
        adapter.setDataList(getFactsList());
        assertEquals(getFactsList().size(),adapter.getItemCount());
    }


    private List<FactsResponseRow> getFactsList(){
        List<FactsResponseRow> list = new ArrayList<>();
        FactsResponseRow row1 = new FactsResponseRow();
        FactsResponseRow row2 = new FactsResponseRow();
        FactsResponseRow row3 = new FactsResponseRow();

        row1.setTitle("Beavers");
        row1.setImageHref("Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony");
        row1.setDescription("http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg");

        row2.setTitle("Flag");
        row2.setImageHref("http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png");
        row2.setDescription("null");

        row3.setTitle("Housing");
        row3.setImageHref("http://icons.iconarchive.com/icons/iconshock/alaska/256/Igloo-icon.png");
        row3.setDescription("Warmer than you might think.");

        list.add(row1);
        list.add(row2);
        list.add(row3);

        return list;

    }

    private FactsResponse getFacts(){
        FactsResponse response = new FactsResponse();
        response.setTitle("FactsApp Canada");
        response.setRow(getFactsList());
        return response;
    }



}