package com.example.newsmvvmapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsmvvmapplication.repository.NewsRepository

class NewsViewModelProviderFactory( val repository: NewsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewViewModel(repository) as T
    }
}