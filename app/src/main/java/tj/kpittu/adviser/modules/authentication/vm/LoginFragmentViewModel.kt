package tj.kpittu.adviser.modules.authentication.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import tj.kpittu.adviser.core.BaseViewModel

class LoginFragmentViewModel(application: Application) : BaseViewModel(application) {
    private val message: MutableLiveData<String> = MutableLiveData()

    fun validate(login: String , password: String): LiveData<Boolean> {
        val status: MutableLiveData<Boolean> = MutableLiveData()

        viewModelScope.launch(Dispatchers.Default) {
            if (login.isNotEmpty() && password.isNotEmpty()) {
                putLogin(login)
                putPassword(password)
                status.postValue(true)

            } else {
                message.value = "login yo parol khato"
                status.postValue(false)
            }
        }
        return status


    }

    fun getMessage(): LiveData<String> {
        return message
    }

    fun setMessage(message: String) {
        this.message.value = message

    }

    fun getLogin(): String? {
        return localStorageRepository.getString(LOGIN)
    }

    fun putLogin(login: String) {
        localStorageRepository.putString(LOGIN , login)
    }

    fun getPassword(): String? {
        return localStorageRepository.getString(PASSWORD)
    }

    fun putPassword(password: String) {
        localStorageRepository.putString(PASSWORD , password)
    }

    companion object {
        const val LOGIN: String = "login"
        const val PASSWORD: String = "password"
    }
}