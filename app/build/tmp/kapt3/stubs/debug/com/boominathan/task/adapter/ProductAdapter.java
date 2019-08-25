package com.boominathan.task.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/boominathan/task/adapter/ProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/boominathan/task/adapter/ProductAdapter$ViewHolder;", "productList", "Ljava/util/ArrayList;", "Lcom/boominathan/task/model/Products;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "DatabaseInstance", "Lcom/boominathan/task/AppDb;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getProductList", "()Ljava/util/ArrayList;", "setProductList", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "id", "ViewHolder", "app_debug"})
public final class ProductAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.boominathan.task.adapter.ProductAdapter.ViewHolder> {
    private com.boominathan.task.AppDb DatabaseInstance;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.boominathan.task.model.Products> productList;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.boominathan.task.adapter.ProductAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.boominathan.task.adapter.ProductAdapter.ViewHolder holder, int position) {
    }
    
    private final void removeItem(int position, int id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.boominathan.task.model.Products> getProductList() {
        return null;
    }
    
    public final void setProductList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.boominathan.task.model.Products> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    public ProductAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.boominathan.task.model.Products> productList, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/boominathan/task/adapter/ProductAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "productDelete", "Landroid/widget/ImageView;", "getProductDelete", "()Landroid/widget/ImageView;", "setProductDelete", "(Landroid/widget/ImageView;)V", "productImage", "getProductImage", "setProductImage", "productMerchant", "getProductMerchant", "setProductMerchant", "productName", "Landroid/widget/TextView;", "getProductName", "()Landroid/widget/TextView;", "setProductName", "(Landroid/widget/TextView;)V", "productPrice", "getProductPrice", "setProductPrice", "productRatings", "Landroid/widget/RatingBar;", "getProductRatings", "()Landroid/widget/RatingBar;", "setProductRatings", "(Landroid/widget/RatingBar;)V", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView productImage;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView productName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView productPrice;
        @org.jetbrains.annotations.NotNull()
        private android.widget.RatingBar productRatings;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView productMerchant;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView productDelete;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getProductImage() {
            return null;
        }
        
        public final void setProductImage(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getProductName() {
            return null;
        }
        
        public final void setProductName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getProductPrice() {
            return null;
        }
        
        public final void setProductPrice(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RatingBar getProductRatings() {
            return null;
        }
        
        public final void setProductRatings(@org.jetbrains.annotations.NotNull()
        android.widget.RatingBar p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getProductMerchant() {
            return null;
        }
        
        public final void setProductMerchant(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getProductDelete() {
            return null;
        }
        
        public final void setProductDelete(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}