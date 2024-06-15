package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.example.netflix.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar


const val PREF_FILE = "ECOPLAY_PREF"
const val EMAIL = "EMAIL"
const val LOGGED = "LOGGED"
const val PASSWORD = "PASSWORD"
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val mSharedPreferences = getSharedPreferences(PREF_FILE, AppCompatActivity.MODE_PRIVATE)
        var email:String?=mSharedPreferences.getString(EMAIL,"no email")
        var logged:Boolean=mSharedPreferences.getBoolean(LOGGED,false)

        if(logged){
            //  emailTf.text=email
            startActivity(Intent(this, HomeActivity::class.java))
        }else{
            //emailTf.text="laaassssbaaaaaaaa"
        }

        var emailInput: EditText =findViewById(R.id.tiEmail)
        var pwdInput: EditText =findViewById(R.id.tiPassword)

        var btnLogin: Button =findViewById(R.id.button)


        emailInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateEmail()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        pwdInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validatePassword()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.button.setOnClickListener {

            if (validateEmail() && validatePassword()){
                if(binding.checkBox2.isChecked){
                    mSharedPreferences.edit().apply{
                        putString(EMAIL, "${binding.tiEmail.text}@esprit.tn".toString())
                        putString(PASSWORD, binding.tiPassword.text?.toString())

                        putBoolean(LOGGED,true)

                    }.apply()
                }
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Snackbar.make(findViewById(android.R.id.content), "msg_error_inputs", Snackbar.LENGTH_SHORT)
//                    .setAction("ACTION") {
//                        // Responds to click on the action
//                    }
                    .show()
            }
        }

    }

    private fun validateEmail(): Boolean {
        binding.tiEmailLayout.isErrorEnabled = false

        if (binding.tiEmail.text.toString().isEmpty()) {
            binding.tiEmailLayout.error = "msg must not be empty"
            binding.tiEmail.requestFocus()
            return false
        }else{
            binding.tiEmailLayout.isErrorEnabled = false
        }

        if (Patterns.EMAIL_ADDRESS.matcher(binding.tiEmail.text.toString()).matches()) {
            binding.tiEmailLayout.error = "msg must not be empty"
            binding.tiEmail.requestFocus()
            return false
        }else{
            binding.tiEmailLayout.isErrorEnabled = false
        }

        return true
    }

    private fun validatePassword(): Boolean {
        binding.tiPasswordLayout.isErrorEnabled = false

        if (binding.tiPassword.text.toString().isEmpty()) {
            binding.tiPasswordLayout.error = "msg must not be empty"
            binding.tiPassword.requestFocus()
            return false
        }else{
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        if (binding.tiPassword.text.toString().length < 6) {
            binding.tiPasswordLayout.error = "msg must not be empty"
            binding.tiPassword.requestFocus()
            return false
        }else{
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        return true
    }
}