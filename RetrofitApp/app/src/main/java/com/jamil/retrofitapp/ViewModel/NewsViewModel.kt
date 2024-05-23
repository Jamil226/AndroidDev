package com.jamil.retrofitapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamil.retrofitapp.models.NewsModel
import com.jamil.retrofitapp.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    //    MutableLiveData in Kotlin (Android) is a class from the Lifecycle library
    //    that acts as an observable data holder specifically designed for use within ViewModels.
    //    It inherits from the LiveData class and provides additional functionality for
    //    modifying the data it holds.

    val newsMutableLiveData:MutableLiveData<List<NewsModel>> = MutableLiveData()

    fun getNews(){

        //Background sy data view model main lana hai
        viewModelScope.launch {
            val response = newsRepository.getNews()
            newsMutableLiveData.value = response
        }
    }
}