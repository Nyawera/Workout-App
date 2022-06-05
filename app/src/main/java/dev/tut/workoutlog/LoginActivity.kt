package dev.tut.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var etEMail:TextInputEditText
    lateinit var etPassword:TextInputEditText
    lateinit var tvSign:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         btnLogin = findViewById(R.id.btnLogin)
        tilEmail = findViewById(R.id.tilEMail)
         tilPassword=findViewById(R.id.tilPassword)
         etEMail = findViewById(R.id.etEMail)
        etPassword=findViewById(R.id.etPassword)
        tvSign=findViewById(R.id.tvSign)

        tvSign.setOnClickListener {
            val intent=Intent(this,SignupActivity::class.java)
           startActivity(intent)
        }

        btnLogin.setOnClickListener {
            validateLogin()
        }

    }
    fun validateLogin(){
        var email = etEMail.text.toString()
        var password=etPassword.text.toString()
        if (email.isBlank()){
            tilEmail.error="Email required please"
        }
        if (password.isBlank()){
            tilPassword.error="password required please"
        }
    }

}