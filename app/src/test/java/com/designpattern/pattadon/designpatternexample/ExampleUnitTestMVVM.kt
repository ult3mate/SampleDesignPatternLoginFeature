package com.designpattern.pattadon.designpatternexample

import com.designpattern.pattadon.designpatternexample.mvvm.MVVMViewModel
import com.designpattern.pattadon.designpatternexample.mvvm.MVVMViewModelToViewInterface
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by pattadon on 9/13/17.
 */

class ExampleUnitTestMVVM {

    var mvvmViewModel : MVVMViewModel? = null

    @Mock
    lateinit var mvvmViewModelInterface : MVVMViewModelToViewInterface

    @Before
    fun setupLoginPresenter() {
        MockitoAnnotations.initMocks(this)
        mvvmViewModel = MVVMViewModel(mvvmViewModelInterface)
    }

    /**
        android.util.Patterns.EMAIL returns null during unit test
        use robolectric to test the class.
     */

//    @Test
//    fun checkEmailFormat(){
//        assertTrue(Patterns.EMAIL_ADDRESS.matcher("aaaa@a.com").matches())
//    }

    @Test
    fun loginCheck(){

    }

//    @Test
//    fun checkTextInLenght(){
//        assertTrue(mvpViewPresenter?.checkUsernameIn6CharacterLength("aaaaaa")!!)
//    }
//
//    @Test
//    fun checkPasswordMatch(){
//        assertTrue(mvpViewPresenter?.checkConfirmPassword("1234","1234")!!)
//    }
//
//    @Test
//    fun validateUpperCase(){
//        assertTrue(mvpViewPresenter?.validateUpperCase("aA123")!!)
//    }
//
//    @Test
//    fun validateLowerCase(){
//        assertTrue(mvpViewPresenter?.validateLowerCase("aA123")!!)
//    }
//
//    @Test
//    fun validateDigitcase(){
//        assertTrue(mvpViewPresenter?.validateDigitCase("aA123")!!)
//    }
}
