package com.designpattern.pattadon.designpatternexample;

import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.designpattern.pattadon.designpatternexample.mvvm.MVVMMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowApplication;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by pattadon on 9/22/17.
 */

@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTestMVVMJava {

    public MVVMMainActivity activity;
    public TextInputEditText usernameEt;
    public TextInputEditText passwordEt;
    public TextInputEditText rePasswordEt;
    public TextInputEditText emailEt;
    public TextView errorMessageTv;
    public Button loginBtn;
    public Button nextBtn;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MVVMMainActivity.class);
        usernameEt = activity.findViewById(R.id.username_et);
        passwordEt = activity.findViewById(R.id.password_et);
        rePasswordEt = activity.findViewById(R.id.repassword_et);
        emailEt = activity.findViewById(R.id.email_et);
        errorMessageTv = activity.findViewById(R.id.login_error_msg);
        loginBtn = activity.findViewById(R.id.login_btn);
        nextBtn = activity.findViewById(R.id.next_btn);
    }

    @Test
    public void loginSuccess() {
        usernameEt.setText("123456789");
        passwordEt.setText("123456789");
        rePasswordEt.setText("123456789");
        emailEt.setText("a@a.com");
        loginBtn.performClick();
        ShadowApplication application = shadowOf(RuntimeEnvironment.application);
        assertThat("Next activity has started", application.getNextStartedActivity(), is(notNullValue()));

    }
}
