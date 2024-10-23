package com.example.blogs.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val id: Int,
    val title: String?,
    val dateGmt: String?,
    val jetpackFeaturedMediaUrl: String?
)
