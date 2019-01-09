package scmp.login.loginkoltinmvvmobservervalidations.ViewModel

import android.content.Context
import android.view.View
import java.util.*

class LoginViewModel(private var context: Context?) : Observable() {

    fun onLoginButtonPressed(view: View) {
    }

    fun reset() {
        context = null
    }
}
