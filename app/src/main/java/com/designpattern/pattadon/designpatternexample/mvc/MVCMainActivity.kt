package com.designpattern.pattadon.designpatternexample.mvc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatEditText
import android.util.Patterns
import com.designpattern.pattadon.designpatternexample.R
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by pattadon on 9/5/17.
 */

class MVCMainActivity : AppCompatActivity() {

    var usernameTv : AppCompatEditText? = null
    var passwordTv : AppCompatEditText? = null
    var repasswordTV : AppCompatEditText? = null
    var emailTv : AppCompatEditText? = null
    private val PASSWORD_UPPER_CASE_PATTERN = "(.*[A-Z].*)"
    private val PASSWORD_LOWER_CASE_PATTERN = "(.*[a-z].*)"
    private val PASSWORD_DIGIT_CASE_PATTERN = "(.*[0-9].*)"
    private var matcher: Matcher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        usernameTv = findViewById(R.id.username_et)
        passwordTv = findViewById(R.id.password_et)
        repasswordTV = findViewById(R.id.repassword_et)
        emailTv = findViewById(R.id.email_et)

    }

    fun checkUsernameIn6CharacterLength(username : String) : Boolean{
        return username.length <= 6
    }

    fun checkConfirmPassword(password : String , rePassword : String) : Boolean{
        return password == rePassword
    }

    fun checkEmailFormat(email : String) : Boolean{
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

//    override fun onLoginSuccess() {
//        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
//    }
//
//    override fun onLoginFail(errorMsg: String) {
//        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
//        if(errorMsg == "No Password"){
////            repassword_til.error = "Incorrect Password"
//        }
//    }

}
