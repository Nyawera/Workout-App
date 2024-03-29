package dev.tut.workoutlog.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
//}



lateinit var sharedPrefs: SharedPreferences
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", AppCompatActivity.MODE_PRIVATE)
    val accessToken= sharedPrefs.getString("ACCESS_TOKEN","")
    if (accessToken!!.isNotBlank()){
        startActivity(Intent(this, HomeActivity::class.java))
    }
    else{
        startActivity(Intent(this, LoginActivity::class.java))
    }
    finish()
}

}
