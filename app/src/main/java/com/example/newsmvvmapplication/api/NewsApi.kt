package com.example.newsmvvmapplication.api


import com.example.newsmvvmapplication.pojo.NewsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
//store the api key and base url
const val API_KEY = "ee1bf3666a2341c287089bbbc798e29f"

interface NewsApi {

    //For Breaking news
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String ="in",
        @Query("page")
        page: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    //For Search news
    @GET("v2/everything")
    suspend fun getSearchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        page: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}
