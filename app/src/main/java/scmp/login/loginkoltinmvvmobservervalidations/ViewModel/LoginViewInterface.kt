package scmp.login.loginkoltinmvvmobservervalidations.ViewModel

interface LoginViewInterface {
    fun showProgress()

    fun hideProgress()

    fun setUsernameError()

    fun setPasswordError()

    fun navigateToHome()
}
