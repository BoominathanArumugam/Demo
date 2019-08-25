package com.boominathan.task;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006\f"}, d2 = {"Lcom/boominathan/task/BookDAO;", "", "deleteRecord", "", "book", "Lcom/boominathan/task/BookEntity;", "getAllBooks", "", "saveBooks", "searchRecord", "merchant", "", "app_debug"})
public abstract interface BookDAO {
    
    @androidx.room.Insert()
    public abstract void saveBooks(@org.jetbrains.annotations.NotNull()
    com.boominathan.task.BookEntity book);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "Select * from BookEntity ORDER BY productId DESC")
    public abstract java.util.List<com.boominathan.task.BookEntity> getAllBooks();
    
    @androidx.room.Delete()
    public abstract void deleteRecord(@org.jetbrains.annotations.NotNull()
    com.boominathan.task.BookEntity book);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM BookEntity WHERE ProductMerchant IN (:merchant) UNION ALL SELECT * FROM BookEntity WHERE ProductMerchant NOT IN (:merchant)")
    public abstract java.util.List<com.boominathan.task.BookEntity> searchRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String merchant);
}