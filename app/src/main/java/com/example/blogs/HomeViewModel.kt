package com.example.blogs

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import retrofit2.Callback
import com.example.blogs.data.Articles
import com.example.blogs.data.ArticlesItem
import com.example.blogs.network.NetworkUtils
import com.example.blogs.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.apache.commons.text.StringEscapeUtils
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HomeViewModel(private val application: Application) : AndroidViewModel(application) {
    val _articles = mutableStateOf<List<ArticlesItem?>?>(null)
    val articles: State<List<ArticlesItem?>?> = _articles

    val _selectedArticle = mutableStateOf<ArticlesItem?>(null)
    val selectedArticle: State<ArticlesItem?> = _selectedArticle

    private val _isNetworkAvailable = MutableStateFlow(true)
    val isNetworkAvailable: StateFlow<Boolean> = _isNetworkAvailable

    fun fetchArticles() {
        if (NetworkUtils.isNetworkAvailable(application)) {
            _isNetworkAvailable.value = true
            viewModelScope.launch {
                val call = RetrofitInstance.apiService.getAllArticles()
                call.enqueue(object : Callback<Articles> {
                    override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                        if (response.isSuccessful) {
                            _articles.value = response.body()
                        }
                    }

                    override fun onFailure(call: Call<Articles>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }
        } else {
            _isNetworkAvailable.value = false

        }

    }

    fun selectArticle(article: ArticlesItem) {
        _selectedArticle.value = article
    }

    fun cleanHTMLContent(content: String?): String {
        val title = StringEscapeUtils.unescapeHtml4(content)
        return title
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDate(dateString: String?): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        val dateTime = LocalDateTime.parse(dateString, inputFormatter)
        val outputFormatter =
            DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm a") // Oct 1, 2024, 02:30 AM
        return dateTime.format(outputFormatter)
    }
}