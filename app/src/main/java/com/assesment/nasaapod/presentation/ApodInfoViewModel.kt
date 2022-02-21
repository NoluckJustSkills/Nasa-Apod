package com.assesment.nasaapod.presentation

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.ObservableChar
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assesment.nasaapod.core.util.Resource
import com.assesment.nasaapod.domain.model.ApodInfo
import com.assesment.nasaapod.domain.usecase.GetApodInfoUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.assesment.nasaapod.BR
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class ApodInfoViewModel @Inject constructor(
    private val getApodInfo: GetApodInfoUsecase
) :ViewModel(){


    var apodInfo:ApodInfo? = null

    fun getApodData() {

        viewModelScope.launch(Dispatchers.Default) {

            getApodInfo()
                .onEach { result ->
                    when(result){
                        is Resource.Success -> {
                            apodInfo = result.data
                            result.data?.title?.let { Log.i("MyLogs", it) }

                        }
                        is Resource.Error -> {
                            Log.i("MyLogs", "error")

                        }
                        is Resource.Loading -> {
                            Log.i("MyLogs", "Loading")
                          //  apodInfo = result.data

                        }
                    }
                }.launchIn(this)
        }
    }

}