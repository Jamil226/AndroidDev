package com.jamil.retrofitapp.utils

import com.jamil.retrofitapp.models.NewsModel
import retrofit2.http.GET

interface Api {

    // Interfaces define contracts that classes can implement.
    // Any class implementing this interface must provide a getNews
    // method that follows this signature
    // Being a suspend function
    // returning a list of NewsModel.


    @GET("LoadNews.php")
    suspend fun getNews():List<NewsModel>
}