package com.jamil.retrofitapp.models

class NewsModel {

    private lateinit var newsID:String
    private lateinit var NewsTitle:String
    private lateinit var NewsDescription:String
    private lateinit var NewsPostBy:String
    private lateinit var NewsDate:String
    private lateinit var NewsImage:String
    private lateinit var NewsLink:String

    constructor(
        newsID: String,
        NewsTitle: String,
        NewsDescription: String,
        NewsPostBy: String,
        NewsDate: String,
        NewsImage: String,
        NewsLink: String
    ) {
        this.newsID = newsID
        this.NewsTitle = NewsTitle
        this.NewsDescription = NewsDescription
        this.NewsPostBy = NewsPostBy
        this.NewsDate = NewsDate
        this.NewsImage = NewsImage
        this.NewsLink = NewsLink
    }


}