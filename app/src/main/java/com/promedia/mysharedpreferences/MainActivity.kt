package com.promedia.mysharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.promedia.mysharedpreferences.SharedPreferences.Companion.prefs
import com.promedia.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    private var opColor = "Amarillo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        getSpinner (b.spinner, R.array.Colores)
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
           prefs.saveCheckColor(b.chbColor.isChecked)
           prefs.saveColor(opColor)
           goAccess()
       } else {
           Snackbar.make(b.root, "Debe rellenar el nombre", Snackbar.LENGTH_SHORT).show()
       }
    }

    private fun goAccess() {
        startActivity(Intent(this, AccesActivity::class.java))
    }

    fun getSpinner(spinner:Spinner, idValores:Int){
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, idValores,
            android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                opColor = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                opColor = "Amarillo"
            }
        }
    }
}