package cognizant.a471515.com.cfacts.ui;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cognizant.a471515.com.cfacts.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainListActivityTest {

    FactsUIInterface factsUIInterface = new MainListActivity();
    FactsPresenterImpl factsPresenter = new FactsPresenterImpl(factsUIInterface);

    @Before
    public void setUpUI(){
        factsPresenter.getFactsCanadaResponse();
    }

    @Rule
    public ActivityTestRule<MainListActivity> mActivityTestRule = new ActivityTestRule<>(MainListActivity.class);

    @Test
    public void mainListActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.facts_title), withText("4 . Hockey Night in Canada"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.facts_recycler_liew),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("4 . Hockey Night in Canada")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.facts_description_heading), withText("Description"),
                        childAtPosition(
                                allOf(withId(R.id.image_description_layout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                1)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Description")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.facts_description_heading), withText("Description"),
                        childAtPosition(
                                allOf(withId(R.id.image_description_layout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                1)),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Description")));

        ViewInteraction textView4 = onView(
                allOf(withText("About Canada"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("About Canada")));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.item_image),
                        childAtPosition(
                                allOf(withId(R.id.image_description_layout),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                1)),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.facts_recycler_liew),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.swipeContainer),
                                        0),
                                0),
                        isDisplayed()));
        recyclerView.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
