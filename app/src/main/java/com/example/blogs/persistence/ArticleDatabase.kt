package com.example.blogs.persistence

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

//@Database annotation to define data base to room
//entities, defining the number of table this database will have, separated by comma
@Database(entities = [ArticleEntity::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    //abstract because room will handle the implementation
    abstract fun articleDao(): ArticleDao

    //companion object, single instance of ArticleDatabase
    companion object {
        //@Volatile ensures that all changes to INSTANCE are immediately visible to all threads.
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getDatabase(context: Context): ArticleDatabase {
            //synchronized block to create and initialize the database instance.
            // This ensures that only one thread can access this code block at a time,
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,
                    "article_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}