package com.example.newsmvvmapplication.repository

import com.example.newsmvvmapplication.api.RetrofitInstance
import com.example.newsmvvmapplication.db.ArticleDatabase

class NewsRepository( val db: ArticleDatabase) {
    suspend fun getBreakingNews(countryCode:String,page:Int)=RetrofitInstance.api.getBreakingNews(countryCode,page)
}