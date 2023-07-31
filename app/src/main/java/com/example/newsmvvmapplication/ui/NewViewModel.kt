package com.example.newsmvvmapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsmvvmapplication.Resouce
import com.example.newsmvvmapplication.pojo.NewsResponse
import com.example.newsmvvmapplication.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class NewViewModel (val newsRepository: NewsRepository): ViewModel(){

val breakingNews : MutableLiveData<Resouce<NewsResponse>> = MutableLiveData()
    var breakingNewsPage =1
    fun getBreakingNews(countryCode:String)= viewModelScope.launch {
        breakingNews.postValue(Resouce.Loading())
        val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }
    private fun handleBreakingNewsResponse(response: Response<NewsResponse>) :Resouce<NewsResponse>{
        if(response.isSuccessful){
            response.body()?.let { resultRespone ->
                return Resouce.Success(resultRespone)
            }
        }
        return Resouce.Error(response.message())
    }

}