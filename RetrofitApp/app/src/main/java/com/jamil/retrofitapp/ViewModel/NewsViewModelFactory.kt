package com.jamil.retrofitapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jamil.retrofitapp.repository.NewsRepository

class NewsViewModelFactory(private val newsRepository: NewsRepository) : ViewModelProvider.Factory{

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
//        TODO("Not Yet Implemented")
        return NewsViewModel(newsRepository) as T
    }


}