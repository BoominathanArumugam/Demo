package com.boominathan.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BookEntity {

    @PrimaryKey(autoGenerate = true)
    var productId: Int = 0

    @ColumnInfo(name = "ProductImage")
    var productImage: String = ""

    @ColumnInfo(name = "ProductName")
    var productName: String = ""

    @ColumnInfo(name = "ProductPrice")
    var productPrice: String = ""

    @ColumnInfo(name = "ProductRatings")
    var productRatings: String = ""

    @ColumnInfo(name = "ProductMerchant")
    var productMerchant: String = ""



}