package com.ecommerce

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Main : AppCompatActivity()
{
    private lateinit var txt_username:EditText
    private lateinit var txt_password:EditText
    private lateinit var next_button:Button
   // private lateinit var cancel_button:Button
    private lateinit var activityIntent:Intent

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txt_username = findViewById(R.id.login_txt_username)
        txt_password = findViewById(R.id.login_txt_password)
        next_button = findViewById(R.id.next_button)

        next_button.setOnClickListener {
            //Validate Username & Password
            if(txt_username != null && isPasswordValid(txt_password.text!!))
            {
                activityIntent = Intent(this, Products::class.java)
                startActivity(activityIntent)
            }

            //Validate Password
            if(isPasswordValid(txt_password.text!!))
            {
                //Clear error message
                txt_password.error = null
            }
            else
            {
                //Show error message
                txt_password.error = getString(R.string.error_password)
            }
        }

    }

    fun isPasswordValid(text:Editable?):Boolean
    {
        return text != null && text.length >= 8
    }
}