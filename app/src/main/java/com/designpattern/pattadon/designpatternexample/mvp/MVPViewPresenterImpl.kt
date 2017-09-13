package com.designpattern.pattadon.designpatternexample.mvp

/**
 * Created by pattadon on 9/5/17.
 */

interface MVPViewPresenterImpl {
    fun onSuccess()
    fun onFail(errorMsg : String)
}