package com.example.newsmvvmapplication.pojo

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)