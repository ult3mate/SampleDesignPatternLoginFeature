package com.designpattern.pattadon.designpatternexample.mvp

/**
 * Created by pattadon on 9/5/17.
 */

interface MVPMainView {
    fun onLoginSuccess()
    fun onLoginFail(errorMsg : String)
}
