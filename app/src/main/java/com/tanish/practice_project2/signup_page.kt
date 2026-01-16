package com.tanish.practice_project2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.security.auth.callback.PasswordCallback

class signup_page : AppCompatActivity() {


    lateinit var etUsername:EditText
    lateinit var  etPassword: EditText
    lateinit var button: Button

    val obj = "signuplifecycle"


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

      etUsername= findViewById(R.id.enterusername)
        etPassword=findViewById(R.id.password)
        button=findViewById(R.id.button)

        button.setOnClickListener {

        val username= etUsername.text.toString().trim()

            val password=etPassword.text.toString().trim()
            if(username.isEmpty()){
              etUsername.error ="enter usrename"
                return@setOnClickListener
            }
            if(password.isEmpty()){
                etPassword.error="empty password"
                return@setOnClickListener
            }
            if(username.equals("tanish")&& password.equals("tanish")){
                Toast.makeText(this,"login successfuly", Toast.LENGTH_SHORT).show()
                val intent= Intent(this@signup_page , LOGIN_SUCCESS::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"wrongpassword",Toast.LENGTH_SHORT).show()
            }
            Log.d(obj, "onCreate called")
        }



    }
    override fun onResume() {
        super.onResume()
       Toast.makeText(this,"resume",Toast.LENGTH_SHORT).show()
    }
    override fun onStart(){
        super.onStart()
     Toast.makeText(this,"start",Toast.LENGTH_SHORT).show()
    }
    override fun onPause(){
        super.onPause()
        Toast.makeText(this,"pause",Toast.LENGTH_SHORT).show()

    }
    override fun onRestart(){
        super.onRestart()
     Toast.makeText(this,"restart",Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"distroy",Toast.LENGTH_SHORT).show()

    }
}