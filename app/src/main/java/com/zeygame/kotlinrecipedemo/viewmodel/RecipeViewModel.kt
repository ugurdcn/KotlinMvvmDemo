package com.zeygame.kotlinrecipedemo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeygame.kotlinrecipedemo.model.ResultModel
import com.zeygame.kotlinrecipedemo.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val repository: RecipeRepository) : ViewModel() {
    private val _response = MutableLiveData<ResultModel>()
    val recipeResponse : LiveData<ResultModel>
    get() = _response

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {


            repository.getRecipe().let {response->
                if (response.isSuccessful){
                    Log.e("DENEMETAG", "getMovies: ${response.body()} ")
                    _response.postValue(response.body())
                }else{
                    Log.e("DENEMETAG", "getMovies: ${response.code()}")
                }

            }
//        }catch (e:Exception){
//            e.printStackTrace()
//        }
    }
}