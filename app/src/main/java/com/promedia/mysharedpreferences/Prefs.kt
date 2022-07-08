package com.promedia.mysharedpreferences

import android.content.Context

class Prefs (val context: Context) {
    val DATABASE = "MyDB"
    val USER_NAME = "UserName"
    val CHECK_COLOR = "Check_Color"
    val COLOR = "Color"
    val storage = context.getSharedPreferences(DATABASE, Context.MODE_PRIVATE)
    // En el MODE_PRIVATE tb podremos poner 0, es lo mismo

    fun saveName (name:String){
        storage.edit().putString(USER_NAME, name).apply()
    }
    fun saveColor(color:String){
        storage.edit().putString(COLOR, color).apply()
    }
    fun saveCheckColor(check:Boolean){
        storage.edit().putBoolean(CHECK_COLOR, check).apply()
    }
    fun getName():String {
        return storage.getString(USER_NAME, "")!!
    }
    fun getCheckColor():Boolean {
        return storage.getBoolean(CHECK_COLOR, false)
    }
    fun getColor(): String{
        return storage.getString(COLOR, "Rojo")!!
    }
    fun cleanData(){
        storage.edit().clear().apply()
    }
}