package com.designpattern.pattadon.designpatternexample.mvvm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.designpattern.pattadon.designpatternexample.R
import com.designpattern.pattadon.designpatternexample.databinding.MvvmSampleBinding

/**
 * Created by pattadon on 9/5/17.
 */

class MVVMMainActivity : AppCompatActivity() , MVVMViewModelToViewInterface {

    var mvvmViewModel : MVVMViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MvvmSampleBinding>(this,R.layout.mvvm_sample)


        mvvmViewModel = MVVMViewModel(this)
        binding.mvvmviewmodel = mvvmViewModel

    }

    override fun onLoginComplete() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mvvmViewModel?.onDestroy()
    }
}
