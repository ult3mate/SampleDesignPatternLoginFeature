package com.designpattern.pattadon.designpatternexample

import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.TextView
import com.designpattern.pattadon.designpatternexample.mvvm.MVVMMainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner



/**
 * Created by pattadon on 9/13/17.
 */

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTestWithRobolectric {

    private val activity : MVVMMainActivity? = null
    private var usernameEt: TextInputEditText? = null
    private var passwordEt: TextInputEditText? = null
    private var rePasswordEt: TextInputEditText? = null
    private var emailEt: TextInputEditText? = null
    private var errorMessageTv: TextView? = null
    private var loginBtn: Button? = null
    private var nextBtn: Button? = null

    @Before
    fun setUp() {
        val activity = Robolectric.setupActivity(MVVMMainActivity::class.java)
        usernameEt = activity.findViewById(R.id.username_et)
        passwordEt = activity.findViewById(R.id.password_et)
        rePasswordEt = activity.findViewById(R.id.repassword_et)
        emailEt = activity.findViewById(R.id.email_et)
        errorMessageTv = activity.findViewById(R.id.login_error_msg)
        loginBtn = activity.findViewById(R.id.login_btn)
        nextBtn = activity.findViewById(R.id.next_btn)
    }

    @Test
    fun loginSuccess() {
        usernameEt?.setText("123456789")
        passwordEt?.setText("123456789")
        rePasswordEt?.setText("123456789")
        emailEt?.setText("a@a.com")
        loginBtn?.performClick()
//        val expectedIntent = Intent(activity, NextActivity::class.java)
//        assertThat(shadowOf(activity).nextStartedActivity).isEqualTo(expectedIntent)

    }
}
