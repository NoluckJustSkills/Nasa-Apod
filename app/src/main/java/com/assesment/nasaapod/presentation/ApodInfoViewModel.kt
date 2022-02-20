package com.assesment.nasaapod.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assesment.nasaapod.core.util.Resource
import com.assesment.nasaapod.domain.usecase.GetApodInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApodInfoViewModel @Inject constructor(
    private val getApodInfo: GetApodInfo
) :ViewModel(){

    fun getApodData() {

        viewModelScope.launch {

            getApodInfo()
                .onEach { result ->
                    when(result){
                        is Resource.Success -> {
                            result.data?.title?.let { Log.i("MyLogs", it) }

                        }
                        is Resource.Error -> {
                            Log.i("MyLogs", "error")

                        }
                        is Resource.Loading -> {
                            Log.i("MyLogs", "Loading")

                        }
                    }
                }.launchIn(this)
        }
    }

}