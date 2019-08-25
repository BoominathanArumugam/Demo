package com.boominathan.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDAO
{
    @Insert
    fun saveBooks(book: BookEntity)

    @Query(value = "Select * from BookEntity ORDER BY productId DESC")
    fun getAllBooks() :  List<BookEntity>

    @Delete
    fun deleteRecord(book: BookEntity)

    @Query("SELECT * FROM BookEntity WHERE ProductMerchant IN (:merchant) UNION ALL SELECT * FROM BookEntity WHERE ProductMerchant NOT IN (:merchant)")
    fun searchRecord(merchant: String): List<BookEntity>






}