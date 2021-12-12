package com.rezapour.woocertask.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewmodel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
}