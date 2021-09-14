package com.zeygame.kotlinrecipedemo.service

import com.zeygame.kotlinrecipedemo.model.ResultModel
import com.zeygame.kotlinrecipedemo.util.Constants
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getRecipe():Response<ResultModel>
}