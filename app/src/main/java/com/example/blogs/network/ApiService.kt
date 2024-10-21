package com.example.blogs.network

import com.example.blogs.data.Articles
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts?per_page=10&page=1")
    fun getAllArticles(): Call<Articles>
}