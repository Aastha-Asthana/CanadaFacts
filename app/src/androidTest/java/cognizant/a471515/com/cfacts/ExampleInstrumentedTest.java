package cognizant.a471515.com.cfacts;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import cognizant.a471515.com.cfacts.adapter.FactsRecyclerAdapter;
import cognizant.a471515.com.cfacts.ui.MainListActivity;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class ExampleInstrumentedTest {

    private String noInternetErrorMessage = "There is some issue, Please try again later.";


    @Rule
    public ActivityTestRule<MainListActivity> activityActivityTestRule = new ActivityTestRule<MainListActivity>(MainListActivity.class);


    @Test
    public void checkSwipeView() {
        onView(withId(R.id.swipeContainer)).check(matches(isDisplayed()));

    }

    @Test
    public void checkRecyclerView() {
        onView(withId(R.id.progressBar_cyclic)).check(matches(isDisplayed()));

    }

    @Test
    public void checkErrorImage() {
        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        onView(withText("CFacts")).check(matches(isDisplayed()));

    }


    @Test
    public void testAPISuccess(){
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        FactsRecyclerAdapter adapter = new FactsRecyclerAdapter(FactsApp.context);
        if(adapter.getItemCount()>0){
            onView(withId(R.id.facts_title)).check(matches(isDisplayed()));
        }

    }

    @Test
    public void testNoInternetError(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        FactsRecyclerAdapter adapter = new FactsRecyclerAdapter(FactsApp.context);
        if(adapter.getItemCount() <= 0){
            onView(withText(noInternetErrorMessage)).check(matches(isDisplayed()));
        }

    }

}


