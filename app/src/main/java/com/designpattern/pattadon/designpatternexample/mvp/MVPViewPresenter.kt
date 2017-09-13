package com.designpattern.pattadon.designpatternexample.mvp

import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by pattadon on 9/5/17.
 */

open class MVPViewPresenter(mvpMainView: MVPMainView?) : MVPViewPresenterImpl {

    private val PASSWORD_UPPER_CASE_PATTERN = "(.*[A-Z].*)"
    private val PASSWORD_LOWER_CASE_PATTERN = "(.*[a-z].*)"
    private val PASSWORD_DIGIT_CASE_PATTERN = "(.*[0-9].*)"
    private var mvpMainView: MVPMainView? = null
    private var mvpLoginServiceModel: MVPLoginServiceModel? = null
    private var matcher: Matcher? = null


    init {
        this.mvpMainView = mvpMainView
    }

    fun onCreate() {
        mvpLoginServiceModel = MVPLoginServiceModel()
    }

    fun onPause() {}
    fun onResume() {}
    fun onDestroy() {}


    fun login(username: String, password: String, rePassword: String, email: String) {
        if (checkUsernameIn6CharacterLength(username)) {
            mvpMainView?.onLoginFail("No Username")
            return
        }
        if (checkConfirmPassword(password, rePassword)) {
            mvpMainView?.onLoginFail("No Password")
            return
        }

        if (checkEmailFormat(email)) {
            mvpMainView?.onLoginFail("No Email")
            return
        }

        if (validateUpperCase(username)) {
            mvpMainView?.onLoginFail("require 1 upper case character")
            return
        }

        if (validateLowerCase(username)) {
            mvpMainView?.onLoginFail("require 1 lower case character")
            return
        }

        if (validateDigitCase(username)) {
            mvpMainView?.onLoginFail("require 1 digit case character")
            return
        }
        mvpLoginServiceModel?.login(username, password, rePassword, email , this)
    }

    fun checkUsernameIn6CharacterLength(username: String): Boolean {
        return username.length <= 6
    }

    fun checkConfirmPassword(password: String, rePassword: String): Boolean {
        return password == rePassword
    }

    fun checkEmailFormat(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validateUpperCase(password: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_UPPER_CASE_PATTERN)
        matcher = pattern.matcher(password)
        return matcher!!.matches()
    }

    fun validateLowerCase(password: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_LOWER_CASE_PATTERN)
        matcher = pattern.matcher(password)
        return matcher!!.matches()
    }

    fun validateDigitCase(password: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_DIGIT_CASE_PATTERN)
        matcher = pattern.matcher(password)
        return matcher!!.matches()
    }

    override fun onSuccess() {
        mvpMainView?.onLoginSuccess()
    }

    override fun onFail(errorMsg: String) {
        mvpMainView?.onLoginFail(errorMsg)
    }
}
