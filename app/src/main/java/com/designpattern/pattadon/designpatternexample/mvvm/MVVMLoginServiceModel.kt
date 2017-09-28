package com.designpattern.pattadon.designpatternexample.mvvm

/**
 * Created by pattadon on 9/5/17.
 */

class MVVMLoginServiceModel {
    fun login(username : String , password : String , rePassword : String , email : String , mvvm : MVVMInterface) {
        if(username == "A12da" && password == rePassword){
            mvvm.onSuccess()
        }else{

        }
    }
}