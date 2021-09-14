package com.zeygame.kotlinrecipedemo.repository

import com.zeygame.kotlinrecipedemo.service.ApiService
import javax.inject.Inject

class RecipeRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getRecipe()=apiService.getRecipe()
}