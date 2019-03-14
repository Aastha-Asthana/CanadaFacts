package cognizant.a471515.com.cfacts;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cognizant.a471515.com.cfacts.listener.APIResponseListener;
import cognizant.a471515.com.cfacts.models.FactsResponse;
import cognizant.a471515.com.cfacts.services.FactsServiceClass;
import cognizant.a471515.com.cfacts.services.FactsServiceInteractor;
import cognizant.a471515.com.cfacts.ui.FactsPresenterImpl;
import cognizant.a471515.com.cfacts.ui.FactsUIInterface;
import cognizant.a471515.com.cfacts.ui.MainListActivity;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<MainListActivity> activityActivityTestRule = new ActivityTestRule<MainListActivity>(MainListActivity.class);


    @Test
    public void checkUI() {
        onView(withId(R.id.swipeContainer)).check(matches(isDisplayed()));

    }

}


