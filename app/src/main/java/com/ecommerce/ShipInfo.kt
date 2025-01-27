package com.ecommerce

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class ShipInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ship_info)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rootView = findViewById<View>(android.R.id.content)
        val textInputLayouts = findViewsWithType(rootView, TextInputLayout::class.java)

        val saveButton: Button = findViewById(R.id.save_button)
        saveButton.setOnClickListener {
            var noErrors = true
            for (textInputLayout in textInputLayouts) {
                val editTextString = textInputLayout.editText?.text.toString()
                if (editTextString.isEmpty()) {
                    textInputLayout.error = getString(R.string.error_string)
                    noErrors = false
                } else {
                    textInputLayout.error = null
                }
            }

            if (noErrors) {
                // All fields are valid!
            }
        }
    }

    private fun <T : View> findViewsWithType(root: View, type: Class<T>): List<T> {
        val views = mutableListOf<T>()
        if (type.isInstance(root)) {
            views.add(type.cast(root)!!)
        }
        if (root is ViewGroup) {
            for (i in 0 until root.childCount) {
                views.addAll(findViewsWithType(root.getChildAt(i), type))
            }
        }
        return views
    }
}