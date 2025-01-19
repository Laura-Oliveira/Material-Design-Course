package com.ecommerce

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ecommerce.view.ProductsView

class MainView : AppCompatActivity()
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
        setContentView(R.layout.main)

        txt_username = findViewById(R.id.login_txt_username)
        txt_password = findViewById(R.id.login_txt_password)
        next_button = findViewById(R.id.next_button)

        next_button.setOnClickListener {

            //Validate Username
            if(!(isUsernameValid(txt_username.text)))
            {
                /* Invalid password, show error message */
                txt_username.error = getString(R.string.error_username)
            }

            //Validate Password
            if(!(isPasswordValid(txt_password.text)))
            {
                /* Invalid password, show error message */
                txt_password.error = getString(R.string.error_password)
            }
            else
            {
                /* Valid password, clear error message */
                txt_password.error = null
            }

            //Validate Username & Password
            if(isUsernameValid(txt_username.text!!) && isPasswordValid(txt_password.text!!))
            {
                activityIntent = Intent(this, ProductsView::class.java)
                startActivity(activityIntent)
            }
        }

    }

    private fun isPasswordValid(text:Editable?):Boolean
    {
        return text != null && text.length >= 8
    }

    private fun isUsernameValid(text: Editable?): Boolean
    {
        return text != null && text.length >= 3 // Example: Username must have at least 3 characters
    }

}