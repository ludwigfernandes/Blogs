package com.example.blogs.persistence

import com.example.blogs.data.ArticlesItem
import com.example.blogs.data.Title

class ArticleRepository(private val articleDao: ArticleDao) {

    suspend fun cacheArticles(articles: List<ArticleEntity>) {
        articleDao.clearAll() // Clear old articles
        articleDao.insertAll(articles) // Insert new articles
    }

    suspend fun getCachedArticles(): List<ArticleEntity> {
        return articleDao.getAll()
    }

    fun mapToEntity(articles: List<ArticlesItem?>?): List<ArticleEntity> {
        return articles?.map {
            ArticleEntity(
                id = it?.id ?: 0,
                title = it?.title?.rendered,
                dateGmt = it?.dateGmt,
                jetpackFeaturedMediaUrl = it?.jetpackFeaturedMediaUrl
            )
        } ?: emptyList()
    }

    fun mapFromEntity(entities: List<ArticleEntity>): List<ArticlesItem> {
        return entities.map {
            ArticlesItem(
                id = it.id,
                title = Title(it.title),
                dateGmt = it.dateGmt,
                jetpackFeaturedMediaUrl = it.jetpackFeaturedMediaUrl
            )
        }
    }
}
