package com.example.blogs.persistence

import androidx.room.*

//DAO for room
@Dao
interface ArticleDao {
    //@Insert, @Query tell room that thi is a method to insert and query respectively
    //suspend is used for async task, they run off the main thread

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles")
    suspend fun getAll(): List<ArticleEntity>

    @Query("DELETE FROM articles")
    suspend fun clearAll()
}