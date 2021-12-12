package com.rezapour.woocertask.viewmodel

import android.provider.ContactsContract
import androidx.lifecycle.*
import com.rezapour.woocertask.data.repository.MainRepository
import com.rezapour.woocertask.di.DatabaseModule_ProvideAppDataBaseFactory
import com.rezapour.woocertask.model.product.Product
import com.rezapour.woocertask.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: MainRepository
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Product>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Product>>> get() = _dataState

    fun getProducts() {
        viewModelScope.launch {
            repository.getProducts().collect {
                _dataState.postValue(it)
            }
        }

    }


}