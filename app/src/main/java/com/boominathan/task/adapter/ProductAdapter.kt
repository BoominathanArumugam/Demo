package com.boominathan.task.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.boominathan.task.AppDb
import com.boominathan.task.BookEntity
import com.boominathan.task.R

import com.boominathan.task.model.Products
import com.bumptech.glide.Glide


class ProductAdapter(var productList: ArrayList<Products>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var DatabaseInstance: AppDb? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent?.context)
            .inflate(com.boominathan.task.R.layout.products_recycler_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        var product: Products = productList[position]

        Glide.with(context).load(product.path).into(holder?.productImage)
        holder?.productName.text = product.name.capitalize()
        holder?.productPrice.text = "Rs. " + product.price + " /-"
        var rating = java.lang.Float.parseFloat(product.ratings)
        holder?.productRatings.rating = rating

        var merchant = product.merchant
        if (merchant.equals("Amazon")) {
            Glide.with(context).load(R.drawable.amazon).into(holder?.productMerchant)

        } else if (merchant.equals("Flipkart")) {
            Glide.with(context).load(R.drawable.flipkar).into(holder?.productMerchant)
        } else {
            Glide.with(context).load(R.drawable.shopclues).into(holder?.productMerchant)
        }

        holder?.productDelete!!.setOnClickListener { view ->

            removeItem(position, product.id)


        }

    }

    private fun removeItem(position: Int, id: Int) {

        DatabaseInstance = AppDb.getInstance(context)
        val thread = Thread {
            var bookEntity = BookEntity()

            bookEntity.productId = id
            DatabaseInstance?.bookDao()?.deleteRecord(bookEntity)
        }
        thread.start()
        productList.removeAt(position)
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, productList.size);


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var productImage = itemView.findViewById(R.id.recycler_product_imageview) as ImageView
        var productName = itemView.findViewById(R.id.recycler_product_name) as TextView
        var productPrice = itemView.findViewById(R.id.recycler_product_rupees) as TextView
        var productRatings = itemView.findViewById(R.id.recycler_product_ratings) as RatingBar
        var productMerchant = itemView.findViewById(R.id.recycler_merchant_image) as ImageView
        var productDelete = itemView.findViewById(R.id.recycler_product_delete) as ImageView
    }

}