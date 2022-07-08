package com.promedia.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        Toast.makeText(this@AccesActivity, prefs.getColor(), Toast.LENGTH_SHORT).show()
        if (prefs.getCheckColor()) {
            val theColor = getMyColor(prefs.getColor())
            b.cvAccess.setBackgroundColor(
                ContextCompat.getColor(this, theColor))
        }
    }
    fun getMyColor(color:String):Int{
        val resourceColor = when(color){
            "Naranja" -> R.color.naranja_claro
            "Gris" -> R.color.gris_claro
            "Amarillo" -> R.color.amarillo_claro
            "Azul" -> R.color.azul_claro
            "Verde" -> R.color.verde_claro
            "Turquesa" -> R.color.turquesa_claro
            else -> R.color.white
        }
        return resourceColor
    }
}