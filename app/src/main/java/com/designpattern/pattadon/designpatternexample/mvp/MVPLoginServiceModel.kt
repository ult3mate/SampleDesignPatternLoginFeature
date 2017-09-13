package com.designpattern.pattadon.designpatternexample.mvp

/**
 * Created by pattadon on 9/5/17.
 */

class MVPLoginServiceModel {
    fun login(username : String , password : String , rePassword : String , email : String , callback : MVPViewPresenterImpl) {
        if(username == "test" && password == rePassword){
            callback.onSuccess()
        }else{
            callback.onFail("Incorrect Username and Password")
        }
    }
}
