package dev.tut.workoutlog.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Telephony
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.tut.workoutlog.R
import dev.tut.workoutlog.databinding.ActivitySignupBinding
import dev.tut.workoutlog.models.RegisterRequest
import dev.tut.workoutlog.viewmodel.UserViewModel




class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validateSign()

        }
        binding.tvSignup.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun validateSign() {
        var name = binding.etFirstName.text.toString()
        var name2 = binding.etLastname.text.toString()
        var phone = binding.etPhoneNumber.editText.toString()
        var mail = binding.etEmail2.text.toString()
        var pass = binding.etPasscode.editText.toString()
        var confirm = binding.etConfirm.editText.toString()

        var error= false
        if (name.isBlank()) {
            binding.txtFirstname.error = "firstname_required"
        }
        if (name2.isBlank()) {
            error =true
            binding.tilLastname.error = "Last name required"
        }
        if (pass.isBlank()) {
            error =true
            binding.tilPhoneNumber.error = "number_required"
        }

        if (mail.isBlank()) {
            error =true
            binding.tilEmail2.error = "email_required"
        }
        if (phone.isBlank()) {
            error =true
            binding.tilPassword.error = "password_required"
        }
        if (confirm.isBlank()) {
            error =true
            binding.tilConfirm.error = "confirmpassword_required"
        }
        if (pass!= confirm) {
            error =true
            binding.tilPassword.error= "password do not match"
        }
        if(!error){
            val  registerRequest=RegisterRequest(name, name2, mail, phone, pass)
//            makeRegistrationRequest(registerRequest)
            userViewModel.registerUser(registerRequest)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer {
                signupResponse->
            Toast.makeText(baseContext,signupResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, LoginActivity::class.java))
        })

        userViewModel.registerErrorLiveData.observe(this, Observer {
                signupError->
            Toast.makeText(baseContext,signupError, Toast.LENGTH_LONG).show()
        })
    }
}

