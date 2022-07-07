package com.promedia.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.promedia.mysharedpreferences.SharedPreferences.Companion.prefs
import com.promedia.mysharedpreferences.databinding.ActivityAccesBinding

class AccesActivity : AppCompatActivity() {
    private lateinit var b:ActivityAccesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAccesBinding.inflate(layoutInflater)
        setContentView(b.root)

        initUI()
    }

    private fun initUI() {
        b.btnCerrar.setOnClickListener {
            prefs.cleanData()
            onBackPressed()
        }
        val userName = prefs.getName()
        b.tvName.text = "¡Hola $userName!"
        if (prefs.getColorCheck()) {
            b.containerLayout.setBackgroundColor(
                ContextCompat.getColor(this, R.color.containerColor))
        }
    }
}