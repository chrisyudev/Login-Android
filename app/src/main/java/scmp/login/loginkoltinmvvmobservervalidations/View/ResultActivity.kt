package scmp.login.loginkoltinmvvmobservervalidations.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import scmp.login.loginkoltinmvvmobservervalidations.R

class ResultActivity:  AppCompatActivity() {
    private var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        result= findViewById(R.id.result)
        var bundle :Bundle ?=intent.extras
        var token = bundle!!.getString("token") // 1

        result!!.text = token

    }
}