package scmp.login.loginkoltinmvvmobservervalidations.View

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import scmp.login.loginkoltinmvvmobservervalidations.R

class ResultActivity:  AppCompatActivity() {
    private var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.token)

        result= findViewById(R.id.result)
        var bundle :Bundle ?=intent.extras
        var token = bundle!!.getString("token") // 1

        result!!.text=  getString(R.string.token) + " : " + token

    }
    override fun onBackPressed(){
        super.onBackPressed()
        finish()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Respond to the action bar's Up/Home button
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}