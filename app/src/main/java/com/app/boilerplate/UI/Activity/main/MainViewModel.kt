package com.app.boilerplate.UI.Activity.main

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.boilerplate.Utils.PreferenceManager
import com.app.boilerplate.model.DemoClass
import com.app.boilerplate.repository.AuthRepository
import kotlinx.coroutines.launch

class MainViewModel (var activity: Activity) : ViewModel() {

    private var preferenceManager: PreferenceManager = PreferenceManager(activity)
    private var authRepository: AuthRepository = AuthRepository(activity)

    fun loginApiCall(hashMap: HashMap<String, Any>): MutableLiveData<DemoClass> {

        var api : MutableLiveData<DemoClass> = MutableLiveData()

        viewModelScope.launch {
            api = authRepository.login(hashMap)
        }

        return api
    }
}