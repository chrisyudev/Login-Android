package scmp.login.loginkoltinmvvmobservervalidations.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import scmp.login.loginkoltinmvvmobservervalidations.Network.JavaConnection
import scmp.login.loginkoltinmvvmobservervalidations.R
import scmp.login.loginkoltinmvvmobservervalidations.Validation.Utils
import scmp.login.loginkoltinmvvmobservervalidations.ViewModel.LoginViewInterface
import scmp.login.loginkoltinmvvmobservervalidations.ViewModel.LoginViewModel
import java.util.*

class LoginActivity : AppCompatActivity() , Observer, LoginViewInterface {
    private var loginViewModel: LoginViewModel? = null
    private var loadingView: View? = null
    private var email: TextView? = null
    private var password:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadingView = findViewById(R.id.loading_view)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
    }

    override fun onDestroy() {
        super.onDestroy()
        loginViewModel!!.reset()
    }

     fun validationAndLogin(v: View?) {
        if(!Utils.isValidEmail(email!!.text.toString()))
            setUsernameError()
        else if(!Utils.isValidPassword(password!!.text.toString()))
            setPasswordError()
         else {
            JavaConnection.registerUser(this,"heyehey@heyhey.com", "1234abcd", loadingView)
        }
    }

    override fun update(o: Observable?, arg: Any?) {
        o!!.addObserver(this)
    }

    override fun showProgress() {
        loadingView!!.visibility = View.VISIBLE;
    }

    override fun hideProgress() {
        loadingView!!.visibility = View.GONE
    }

    override fun setUsernameError() {
        email!!.error = getString(R.string.error_invalid_email)
        email!!.requestFocus()
    }

    override fun setPasswordError() {
        password!!.error = getString(R.string.error_invalid_password)
        password!!.requestFocus()
    }
    override fun navigateToHome() {
    }

}
