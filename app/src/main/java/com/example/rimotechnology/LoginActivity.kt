package com.example.rimotechnology

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception
import kotlin.time.toDuration

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val loginbtn = findViewById<Button>(R.id.login_btn)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar_it)
        progressbar.visibility = View.GONE
        loginbtn.setOnClickListener {
            val editPhone = findViewById<EditText>(R.id.edit_phone).text.toString()
            val editPass = findViewById<EditText>(R.id.edit_pass).text.toString()
            if (editPhone.isNotEmpty() && editPass.isNotEmpty()) {
                progressBar_it.visibility = View.VISIBLE
                val loginData = LoginData(editPhone, editPass, "d780544a42bdb1c4QP1A.190711.020", "samsung")
                viewModel.getLogin(loginData)
                viewModel.postLogin.observeOnce(this, { response ->
                    try {
                        if (response.data!!.code() == 200) {
                            progressBar_it.visibility = View.GONE
                            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        } else {
                            if (response.data.errorBody() != null) {
                                progressBar_it.visibility = View.GONE
                                Toast.makeText(
                                    this,
                                    "Invalid Login Credentials",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }


                    } catch (e: Exception) {
                        progressBar_it.visibility = View.GONE
                        Toast.makeText(this, "Uknown Error Occured", Toast.LENGTH_SHORT).show()
                    }
                })

            }else{
                Toast.makeText(this, "Input Some Text", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
