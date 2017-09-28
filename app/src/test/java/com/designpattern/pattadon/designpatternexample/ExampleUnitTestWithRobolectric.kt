package com.designpattern.pattadon.designpatternexample

import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.TextView
import com.designpattern.pattadon.designpatternexample.mvp.MVPLoginServiceModel
import com.designpattern.pattadon.designpatternexample.mvp.MVPMainActivity
import com.designpattern.pattadon.designpatternexample.mvp.MVPMainView
import com.designpattern.pattadon.designpatternexample.mvp.MVPViewPresenter
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config







/**
 * Created by pattadon on 9/13/17.
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class ExampleUnitTestWithRobolectric {

    var mvpViewPresenter: MVPViewPresenter? = null

    @Mock
    val mvpMainView: MVPMainView? = null

    lateinit var mvpLoginServiceModel : MVPLoginServiceModel

    private var activity: MVPMainActivity? = null
    private var usernameEt: TextInputEditText? = null
    private var passwordEt: TextInputEditText? = null
    private var rePasswordEt: TextInputEditText? = null
    private var errorTv: TextView? = null
    private var emailEt: TextInputEditText? = null
    private var errorMessageTv: TextView? = null
    private var loginBtn: Button? = null
    private var nextBtn: Button? = null

    private var controller: ActivityController<MVPMainActivity>? = null

    @Before
    fun setUp() {
        activity = Robolectric.setupActivity(MVPMainActivity::class.java)
        usernameEt = activity?.findViewById(R.id.username_et)
        passwordEt = activity?.findViewById(R.id.password_et)
        rePasswordEt = activity?.findViewById(R.id.repassword_et)
        emailEt = activity?.findViewById(R.id.email_et)
        errorMessageTv = activity?.findViewById(R.id.login_error_msg)
        loginBtn = activity?.findViewById(R.id.login_btn)
        nextBtn = activity?.findViewById(R.id.next_btn)
        errorTv = activity?.findViewById(R.id.login_error_msg)
        mvpLoginServiceModel = MVPLoginServiceModel()
        mvpViewPresenter = MVPViewPresenter(mvpMainView)


        controller = Robolectric.buildActivity(MVPMainActivity::class.java!!)
    }

    @Test
    fun loginSuccess() {
        usernameEt?.setText("123456789")
        passwordEt?.setText("123456789")
        rePasswordEt?.setText("123456789")
        emailEt?.setText("a@a.com")
        loginBtn?.performClick()

//        val application = shadowOf(RuntimeEnvironment.application)
//        assertThat("Next activity has started", application.nextStartedActivity, `is`(notNullValue()))

    }

    @Test
    fun loginWithEmptyUsernameAndPassword() {
        loginBtn?.performClick()
        assertThat("No username", errorTv?.text.toString(), `is`(nullValue()))
    }


    @Test
    fun loginFailure() {
        usernameEt?.setText("username")
        passwordEt?.setText("123456789")
        loginBtn?.performClick()

        val application = shadowOf(RuntimeEnvironment.application)
        assertThat("Next activity should not started", application.getNextStartedActivity(), `is`(nullValue()))
    }
}
