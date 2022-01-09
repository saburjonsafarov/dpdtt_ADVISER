package tj.kpittu.adviser.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import tj.kpittu.adviser.repository.local.LocalStorageRepository

abstract class BaseViewModel(application: Application):AndroidViewModel(application) {
protected var localStorageRepository:LocalStorageRepository = LocalStorageRepository(application)
}