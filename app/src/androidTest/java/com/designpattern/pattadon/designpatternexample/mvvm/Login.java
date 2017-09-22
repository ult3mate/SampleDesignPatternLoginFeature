package com.designpattern.pattadon.designpatternexample.mvvm;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.designpattern.pattadon.designpatternexample.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Login {

    @Rule
    public ActivityTestRule<MVVMMainActivity> mActivityTestRule = new ActivityTestRule<>(MVVMMainActivity.class);

    @Test
    public void login() {
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.username_mvvm_et),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.username_mvvm_til),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.username_mvvm_et),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.username_mvvm_til),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("tester"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.password_mvvm_et),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_mvvm_til),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("124567"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.repassword_mvvm_et),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.repassword_mvvm_til),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("124567"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.email_mvvm_et),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.email_mvvm_til),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("a@a.com"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.login_mvvm_btn), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

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
