package com.designpattern.pattadon.designpatternexample.mvvm

import android.databinding.ObservableField
import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by pattadon on 9/8/17.
 */

class MVVMViewModel(mvvmCallback: MVVMViewModelToViewInterface?) : MVVMInterface {


    private val PASSWORD_UPPER_CASE_PATTERN = "(.*[A-Z].*)"
    private val PASSWORD_LOWER_CASE_PATTERN = "(.*[a-z].*)"
    private val PASSWORD_DIGIT_CASE_PATTERN = "(.*[0-9].*)"

    var mvvmCallback: MVVMViewModelToViewInterface? = null
    var mvvmLoginServiceModel: MVVMLoginServiceModel? = null
    val username = ObservableField<String>("")
    val password = ObservableField<String>("")
    val rePassword = ObservableField<String>("")
    val email = ObservableField<String>("")
    val errorMessage = ObservableField<String>("")
    var matcher: Matcher? = null

    init {
        this.mvvmLoginServiceModel = MVVMLoginServiceModel()
        this.mvvmCallback = mvvmCallback
    }

    fun login() {
        if (!checkUsernameIn6CharacterLength(username.get())) {
            errorMessage.set("No Username")
            return
        }
        if (!checkConfirmPassword(password.get(), rePassword.get())) {
            errorMessage.set("Password incorrect")
            return
        }

        if (!checkEmailFormat(email.get())) {
            errorMessage.set("No Email")
            return
        }

        if (!validateUpperCase(username.get())) {
            errorMessage.set("require 1 upper case character")
            return
        }

        if (!validateLowerCase(username.get())) {
            errorMessage.set("require 1 lower case character")
            return
        }

        if (!validateDigitCase(username.get())) {
            errorMessage.set("require 1 digit case character")
            return
        }
        mvvmLoginServiceModel?.login(username.get(), password.get(), rePassword.get(), email.get() , this)
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
        mvvmCallback?.onLoginComplete()
    }

    override fun onFail(errorMsg: String) {
        errorMessage.set(errorMsg)
    }

    fun startNextAct() {
        mvvmCallback?.onStartActivity()
    }

    fun onDestroy() {
        // prevent memory leak
        mvvmCallback = null
        mvvmLoginServiceModel = null
    }
}
