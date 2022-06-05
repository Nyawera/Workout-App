package dev.tut.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastname: TextInputEditText
    lateinit var etEmail2: TextInputEditText
    lateinit var etPasscode: TextInputEditText
    lateinit var etConfirm: TextInputEditText

    lateinit var tilFirstName:TextInputLayout
    lateinit var tilLastname:TextInputLayout
    lateinit var tilEmail2:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var tilConfirm:TextInputLayout
    lateinit var btnSignUp:Button
    lateinit var tvSignup:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        etFirstName = findViewById(R.id.etFirstName)
        etLastname = findViewById(R.id.etLastname)
        etEmail2 = findViewById(R.id.etEmail2)
        etPasscode = findViewById(R.id.etPasscode)
        etConfirm = findViewById(R.id.etConfirm)
        tilFirstName = findViewById(R.id.txtFirstname)
        tilLastname = findViewById(R.id.tilLastname)
        tilEmail2 = findViewById(R.id.tilEmail2)
        tilPassword = findViewById(R.id.tilPassword)
        etConfirm = findViewById(R.id.etConfirm)
        tilConfirm = findViewById(R.id.tilConfirm)
        btnSignUp = findViewById(R.id.btnSignup)
        tvSignup = findViewById(R.id.tvSignup)
        btnSignUp.setOnClickListener {
            validateLogin()
        }
        tvSignup.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        }

    fun validateLogin(){
        var firstname =etFirstName.text.toString()
        var lastname = etLastname .text.toString()
        var Email = etEmail2.text.toString()
        var PassCode = etPasscode.text.toString()
        var Confirm = etConfirm.text.toString()

        if (firstname.isBlank()){
            etFirstName.error= "Enter First Name"
        }
        if (lastname.isBlank()){
            etLastname.error= "Enter Last Name"
        }

        if ( Email.isBlank()){
             etEmail2.error= "Email is required"
        }
        if (PassCode.isBlank()){
            etPasscode.error= "Password is required"
        }
        if(Confirm.isBlank()){
            etConfirm.error="Error"
        }



    }
}