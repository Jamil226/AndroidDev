package com.jamil.retrofitapp.repository

import com.jamil.retrofitapp.models.NewsModel
import com.jamil.retrofitapp.utils.RetrofitBuilder

class NewsRepository {

    //Server sy data repository class main get ho ga
    //Suspend function will load data in background
    suspend fun getNews():List<NewsModel> = RetrofitBuilder.api.getNews()
}