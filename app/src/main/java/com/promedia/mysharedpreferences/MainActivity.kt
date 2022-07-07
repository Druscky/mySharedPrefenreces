package com.promedia.mysharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.promedia.mysharedpreferences.SharedPreferences.Companion.prefs
import com.promedia.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        initUI()
        checkUserValues()
    }

    fun initUI(){
        b.btnEntrar.setOnClickListener {
            accessSharedPreferences()
        }
    }

    private fun checkUserValues() {
        if(prefs.getName().isNotEmpty()){
            goAccess()
        }
    }

    private fun accessSharedPreferences() {
       if (b.etName.text.toString().isNotEmpty()) {
           prefs.saveName(b.etName.text.toString())
           prefs.saveColor(b.chbColor.isChecked)
           goAccess()
       } else {
           Snackbar.make(b.root, "Debe rellenar el nombre", Snackbar.LENGTH_SHORT).show()
       }
    }

    private fun goAccess() {
        startActivity(Intent(this, AccesActivity::class.java))
    }
}