package com.example.blogs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import retrofit2.Callback
import com.example.blogs.data.Articles
import com.example.blogs.data.ArticlesItem
import com.example.blogs.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class HomeViewModel : ViewModel() {
    val _articles = mutableStateOf<List<ArticlesItem?>?>(null)
    val articles: State<List<ArticlesItem?>?> = _articles

    val _selectedArticle = mutableStateOf<ArticlesItem?>(null)
    val selectedArticle: State<ArticlesItem?> = _selectedArticle

    fun fetchArticles() {
        viewModelScope.launch {
            val call = RetrofitInstance.apiService.getAllArticles()
            call.enqueue(object : Callback<Articles> {
                override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                    if (response.isSuccessful){
                        _articles.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Articles>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    fun selectArticle(article: ArticlesItem){
        _selectedArticle.value=article
    }
}