package com.example.blogs

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogs.data.Articles
import com.example.blogs.data.ArticlesItem
import com.example.blogs.network.NetworkUtils
import com.example.blogs.network.RetrofitInstance
import com.example.blogs.persistence.ArticleDatabase
import com.example.blogs.persistence.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.commons.text.StringEscapeUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HomeViewModel(private val application: Application /*, private val repository: ArticleRepository*/) : AndroidViewModel(application) {
    val _articles = mutableStateOf<List<ArticlesItem?>?>(null)
    val articles: State<List<ArticlesItem?>?> = _articles

    val _selectedArticle = mutableStateOf<ArticlesItem?>(null)
    val selectedArticle: State<ArticlesItem?> = _selectedArticle

    private val _isNetworkAvailable = MutableStateFlow(true)
    val isNetworkAvailable: StateFlow<Boolean> = _isNetworkAvailable

    val database = ArticleDatabase.getDatabase(application)
    val repository = ArticleRepository(database.articleDao())

    suspend fun fetchArticles() {
        if (NetworkUtils.isNetworkAvailable(application)) {
            _isNetworkAvailable.value = true
            viewModelScope.launch {
                val call = RetrofitInstance.apiService.getAllArticles()
                call.enqueue(object : Callback<Articles> {
                    override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                        if (response.isSuccessful) {
                            _articles.value = response.body()
                            viewModelScope.launch(Dispatchers.IO) {
                                repository.cacheArticles(repository.mapToEntity(response.body()))
                            }
                        }
                    }

                    override fun onFailure(call: Call<Articles>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }
        } else {
            _isNetworkAvailable.value = false
            withContext(Dispatchers.IO) {
                val cachedArticles = repository.getCachedArticles()
                _articles.value = repository.mapFromEntity(cachedArticles)
            }
        }

    }

    fun selectArticle(article: ArticlesItem) {
        _selectedArticle.value = article
    }

    fun cleanHTMLContent(content: String?): String {
        //Apache Commons Lang to unescape HTML entities in a string.
        val title = StringEscapeUtils.unescapeHtml4(content)
        return title
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDate(dateString: String?): String {
        //the format of the passed date
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        //parsing the value
        val dateTime = LocalDateTime.parse(dateString, inputFormatter)
        //specifying output format
        val outputFormatter =
            DateTimeFormatter.ofPattern("MMM d, yyyy, hh:mm a")
        //formating and returning according to the specified format
        return dateTime.format(outputFormatter)
    }
}