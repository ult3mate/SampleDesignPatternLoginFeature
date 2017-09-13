package com.designpattern.pattadon.designpatternexample.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.widget.Toast
import com.designpattern.pattadon.designpatternexample.R
import kotlinx.android.synthetic.main.activity_sample.*

class MVPMainActivity : AppCompatActivity(), MVPMainView {

    var usernameTv: AppCompatEditText? = null
    var passwordTv: AppCompatEditText? = null
    var repasswordTV: AppCompatEditText? = null
    var emailTv: AppCompatEditText? = null
    var loginBtn: AppCompatButton? = null

    var mvpViewPresenter: MVPViewPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        usernameTv = findViewById(R.id.username_et)
        passwordTv = findViewById(R.id.password_et)
        repasswordTV = findViewById(R.id.repassword_et)
        emailTv = findViewById(R.id.email_et)
        loginBtn = findViewById(R.id.login_btn)

        loginBtn?.setOnClickListener {
            resetErrorInputView()
            mvpViewPresenter?.login(usernameTv?.text.toString(),
                    passwordTv?.text.toString(),
                    repasswordTV?.text.toString(),
                    emailTv?.text.toString())
        }

        mvpViewPresenter = MVPViewPresenter(this)
        mvpViewPresenter?.onCreate()
    }

    private fun resetErrorInputView(){
        username_til.error = null
        password_til.error = null
        repassword_til.error = null
        email_til.error = null
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
    }

    override fun onLoginFail(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
        if(errorMsg == "No Password"){
            repassword_til.error = "Incorrect Password"
        }
    }

    override fun onDestroy() {
        mvpViewPresenter?.onDestroy()
        super.onDestroy()
    }
}
