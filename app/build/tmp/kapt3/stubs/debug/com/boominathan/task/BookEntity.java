package com.boominathan.task;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/boominathan/task/BookEntity;", "", "()V", "productId", "", "getProductId", "()I", "setProductId", "(I)V", "productImage", "", "getProductImage", "()Ljava/lang/String;", "setProductImage", "(Ljava/lang/String;)V", "productMerchant", "getProductMerchant", "setProductMerchant", "productName", "getProductName", "setProductName", "productPrice", "getProductPrice", "setProductPrice", "productRatings", "getProductRatings", "setProductRatings", "app_debug"})
public final class BookEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int productId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ProductImage")
    private java.lang.String productImage;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ProductName")
    private java.lang.String productName;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ProductPrice")
    private java.lang.String productPrice;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ProductRatings")
    private java.lang.String productRatings;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "ProductMerchant")
    private java.lang.String productMerchant;
    
    public final int getProductId() {
        return 0;
    }
    
    public final void setProductId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductImage() {
        return null;
    }
    
    public final void setProductImage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductName() {
        return null;
    }
    
    public final void setProductName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductPrice() {
        return null;
    }
    
    public final void setProductPrice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductRatings() {
        return null;
    }
    
    public final void setProductRatings(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProductMerchant() {
        return null;
    }
    
    public final void setProductMerchant(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public BookEntity() {
        super();
    }
}