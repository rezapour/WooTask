package com.rezapour.woocertask.viewmodel

import android.provider.ContactsContract
import android.util.Log
import android.util.LogPrinter
import android.util.Patterns
import androidx.lifecycle.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rezapour.woocertask.data.repository.MainRepository
import com.rezapour.woocertask.model.user.User
import com.rezapour.woocertask.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewmodel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: MainRepository
) :
    ViewModel() {

    private val _dataState: MutableLiveData<DataState<User>> = MutableLiveData()
    val dataState: LiveData<DataState<User>> get() = _dataState

    val isLogin = repository.getUser().asLiveData()


    fun saveUser(user: User) {
        _dataState.value = DataState.Loading
        if (!validateName(user.name)) {
            _dataState.value = DataState.Error("Name is not correct please check it")
            return
        }
        if (!validateEmail(user.email)) {
            _dataState.value = DataState.Error("Email address is not correct please check it")
            return
        }
        if (!validateWebsite(user.webSite)) {
            _dataState.value = DataState.Error("WebSite is not correct please check it")
            return
        }

        if (!validateConsumerKey(user.consumerKey)) {
            _dataState.value = DataState.Error("consumerKey is not correct please check it")
            return
        }
        if (!validateConsumerSecret(user.consumerSecret)) {
            _dataState.value = DataState.Error("consumerSecret is not correct please check it")
            return
        }
        viewModelScope.launch {
            repository.saveUser(user).collect {
                _dataState.postValue(it)
            }
        }
    }

    private fun validateName(name: String): Boolean {
        if (name.isEmpty())
            return false
        if (name.length > 30)
            return false
        return true
    }

    private fun validateEmail(email: String): Boolean {
        if (email.isEmpty())
            return false
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return false
        return true
    }

    private fun validateWebsite(Url: String): Boolean {
        if (Url.isEmpty())
            return false
        if (!Patterns.WEB_URL.matcher(Url).matches())
            return false
        return true
    }

    private fun validateConsumerKey(consumerKey: String): Boolean {
        if (consumerKey.isEmpty())
            return false
        if (!consumerKey.startsWith("ck_"))
            return false
        return true
    }

    private fun validateConsumerSecret(consumerSecret: String): Boolean {
        if (consumerSecret.isEmpty())
            return false
        if (!consumerSecret.startsWith("cs_"))
            return false
        return true
    }

}