package scmp.login.loginkoltinmvvmobservervalidations.Validation
import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern


public class Utils {

    companion object {
        fun isValidEmail(target: CharSequence): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }

        fun isValidPassword(text: String): Boolean {
            return if (text.length < 6 || text.length > 8) false else text.matches("^[a-zA-Z0-9]+$".toRegex())
        }
    }

}