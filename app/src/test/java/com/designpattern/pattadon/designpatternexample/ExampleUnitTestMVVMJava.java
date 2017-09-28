package com.designpattern.pattadon.designpatternexample;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.designpattern.pattadon.designpatternexample.mvvm.MVVMMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import static junit.framework.Assert.assertEquals;

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
        usernameEt = activity.findViewById(R.id.username_mvvm_et);
        passwordEt = activity.findViewById(R.id.password_mvvm_et);
        rePasswordEt = activity.findViewById(R.id.repassword_mvvm_et);
        emailEt = activity.findViewById(R.id.email_mvvm_et);
        errorMessageTv = activity.findViewById(R.id.login_error_msg);
        loginBtn = activity.findViewById(R.id.login_mvvm_btn);
        nextBtn = activity.findViewById(R.id.next_btn);
    }

    @Test
    public void loginSuccess() {
        usernameEt.setText("A12da");
        passwordEt.setText("123456789");
        rePasswordEt.setText("123456789");
        emailEt.setText("a@a.com");
        loginBtn.performClick();

        Intent expectedIntent = new Intent(activity, NextActivity.class);
        Intent actual = ShadowApplication.getInstance().getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}
