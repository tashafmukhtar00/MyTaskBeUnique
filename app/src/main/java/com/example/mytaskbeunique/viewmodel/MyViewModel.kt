package com.example.mytaskbeunique.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytaskbeunique.model.DataY
import com.example.mytaskbeunique.network.InterestApi
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {


    private val _property = MutableLiveData<List<DataY>>()

    val property: LiveData<List<DataY>>
        get() = _property


    private val TAG = "tAshaf"

    init {
        getDataWithCoroutine()
        Log.d(TAG, ":ViewModel Created ")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, ": View Model clearded")
    }


    public fun getData() {


//        MarsApi.retrofitService.getProperties().enqueue(
//            object : Callback<List<MarsProperties>> {
//                override fun onResponse(
//                    call: Call<List<MarsProperties>>,
//                    response: Response<List<MarsProperties>>
//                ) {
//                        marsProperties = response.body();
//
//
//
//
//                }
//
//                override fun onFailure(call: Call<List<MarsProperties>>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//
//
//        Log.d(TAG, "getData: getData called")


    }


    public fun getDataWithCoroutine() {
        viewModelScope.launch {
            try {
                val listResult = InterestApi.retrofitService.getPhots()
                Log.d(TAG, "getDataWithCoroutine: " + listResult.size)
                if (listResult.isNotEmpty()) {
                    _property.value = listResult
                }

            } catch (e: Exception) {

            }
        }
    }

}