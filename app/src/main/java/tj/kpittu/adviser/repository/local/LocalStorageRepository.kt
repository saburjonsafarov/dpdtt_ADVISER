package tj.kpittu.adviser.repository.local

import android.content.Context
import android.content.SharedPreferences

class LocalStorageRepository(private val context: Context) {

    private val sharedPreferences:SharedPreferences
    init {
        sharedPreferences = context.getSharedPreferences("settings",Context.MODE_PRIVATE)
    }
    fun putString(key: String,value:String){
        sharedPreferences.edit().putString(key,value).apply()

    }

    fun getString(key:String,defaultValue:String? = null):String?{
        if (sharedPreferences.contains(key)){
            return sharedPreferences.getString(key,defaultValue)
        }
        return defaultValue
    }

}