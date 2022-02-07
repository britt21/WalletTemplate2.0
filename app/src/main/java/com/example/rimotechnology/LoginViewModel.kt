package com.example.rimotechnology

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginViewModel : ViewModel() {


    val postLogin : MutableLiveData<NetworkResult<Response<LoginData>>> = MutableLiveData()


    fun getLogin(postLoginData: LoginData){
        viewModelScope.launch {
            getLoginSafecall(postLoginData)
        }
    }

    suspend fun getLoginSafecall(postLoginData: LoginData) {



            val response = RetrofitApi.RetrofitService.PostLogin(postLoginData)
            postLogin.value = handleResponse(response)
        }
    }



    private fun handleResponse(response: Response<LoginData>): NetworkResult<Response<LoginData>>? {

        when {
            response.code() == 200 -> {
                val result = response
                return  NetworkResult.Sucess(result)
            }
            else -> {
                return NetworkResult.Error("No Internet Connection")

            }
        }
    }



