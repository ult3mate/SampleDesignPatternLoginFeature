package com.designpattern.pattadon.designpatternexample

import com.designpattern.pattadon.designpatternexample.mvp.MVPMainView
import com.designpattern.pattadon.designpatternexample.mvp.MVPViewPresenter
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
/**
 * Example local unit test, which will execute on the development machine (host).
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    var mvpViewPresenter : MVPViewPresenter? = null
    var mvpMainView : MVPMainView? = null

    @Before
    fun setupLoginPresenter() {
        MockitoAnnotations.initMocks(this)
        mvpViewPresenter = MVPViewPresenter(mvpMainView)
    }

//    @Test
//    fun checkEmailFormat(){
//        assertTrue(Patterns.EMAIL_ADDRESS.matcher("aaaa@a.com").matches())
//    }

    @Test
    fun loginCheck(){
        mvpViewPresenter?.login("test","1234567","1234567","aaa@a.com")
        verify(mvpMainView)?.onLoginSuccess()
    }

    @Test
    fun checkTextInLenght(){
        assertTrue(mvpViewPresenter?.checkUsernameIn6CharacterLength("aaaaaaa")!!)
    }

    @Test
    fun checkPasswordMatch(){
        assertTrue(mvpViewPresenter?.checkConfirmPassword("1234","1234")!!)
    }

    @Test
    fun validateUpperCase(){
        assertTrue(mvpViewPresenter?.validateUpperCase("aA123")!!)
    }

    @Test
    fun validateLowerCase(){
        assertTrue(mvpViewPresenter?.validateLowerCase("aA123")!!)
    }

    @Test
    fun validateDigitcase(){
        assertTrue(mvpViewPresenter?.validateDigitCase("aA123")!!)
    }

}
