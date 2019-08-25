package com.boominathan.task

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.provider.MediaStore
import com.google.android.material.snackbar.Snackbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log
import android.view.*
import android.widget.*
import androidx.annotation.Nullable
import androidx.annotation.UiThread
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.boominathan.task.adapter.ProductAdapter
import com.boominathan.task.model.Products
import com.bumptech.glide.Glide
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.product_details.*
import kotlinx.android.synthetic.main.product_details.view.*
import kotlinx.android.synthetic.main.products_recycler_items.view.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*
import java.util.concurrent.Executor
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"
    private var imageview: ImageView? = null
    private val GALLERY = 1
    private val CAMERA = 2
    private var path: String? = null


    private var product = ArrayList<Products>()
    private lateinit var recyclerView: RecyclerView

    private var DatabaseInstance: AppDb? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        DatabaseInstance = AppDb.getInstance(this@MainActivity)

        Log.e("Oncreate", "");



        recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        if (product.size != null) {
            product.clear()
        }


        val thread = Thread {
            DatabaseInstance?.bookDao()?.getAllBooks()?.forEach()
            {
                Log.i("Fetch Records", "Id:  : ${it.productId}")
                Log.i("Fetch Records", "Name:  : ${it.productName}")
                Log.i("Fetch Records", "Image:  : ${it.productImage}")
                Log.i("Fetch Records", "Price:  : ${it.productPrice}")
                Log.i("Fetch Records", "Ratings:  : ${it.productRatings}")
                Log.i("Fetch Records", "Merchant:  : ${it.productMerchant}")


                product.add(
                    Products(
                        it.productId,
                        it.productName,
                        it.productImage,
                        it.productPrice,
                        it.productRatings,
                        it.productMerchant
                    )
                )
            }
        }
        thread.start()

        var adapter = ProductAdapter(product, this@MainActivity)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()



            fab.setOnClickListener { view ->

                var mDialogView = LayoutInflater.from(this).inflate(R.layout.product_details, null)
                imageview = mDialogView.findViewById<View>(R.id.product_imageview) as ImageView



                imageview!!.setOnClickListener {

                    if (checkAndRequestPermissions()) {

                        showPictureDialog()


                    } else {
                        showPictureDialog()
                    }


                }

                //AlertDialogBuilder
                var mBuilder = AlertDialog.Builder(this, R.style.DialogTheme)
                    .setView(mDialogView)


                //show dialog
                var mAlertDialog = mBuilder.show()
                //login button click of custom layout

                var merchants = arrayOf("Flipkart", "Amazon", "Shopclues")
                var arrayAdapter = ArrayAdapter(this, R.layout.spinner_item, merchants)
                mDialogView.product_merchant.adapter = arrayAdapter
                var product_sellers = ""
                mDialogView.product_merchant.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(p0: AdapterView<*>?) {
                        }

                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                            product_sellers = merchants[p2]
                        }

                    }



                mDialogView.add_product.setOnClickListener {
                    //dismiss dialog
                    mAlertDialog.dismiss()
                    //get text from EditTexts of custom layout
                    var product_name = mDialogView.product_name.text.toString()
                    var product_price = mDialogView.product_price.text.toString()
                    var product_ratings = mDialogView.product_ratings.rating



                    var bookEntity = BookEntity()
                    bookEntity.productImage = path.toString()
                    bookEntity.productName = product_name
                    bookEntity.productPrice = product_price
                    bookEntity.productRatings = product_ratings.toString()
                    bookEntity.productMerchant = product_sellers

                    DatabaseInstance?.bookDao()?.saveBooks(bookEntity)



                }


            }



    }


    override fun onResume() {
        super.onResume()


        Log.e(TAG, "OnResume")

    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        when (id) {

            R.id.flipkart -> {
                Toast.makeText(this, "Flipkart", Toast.LENGTH_SHORT).show()
                if (product.size != null) {
                    product.clear()
                }


                val thread = Thread {
                    DatabaseInstance?.bookDao()?.searchRecord("Flipkart")?.forEach()
                    {
                        Log.i("Fetch Records", "Id:  : ${it.productId}")
                        Log.i("Fetch Records", "Name:  : ${it.productName}")
                        Log.i("Fetch Records", "Image:  : ${it.productImage}")
                        Log.i("Fetch Records", "Price:  : ${it.productPrice}")
                        Log.i("Fetch Records", "Ratings:  : ${it.productRatings}")
                        Log.i("Fetch Records", "Merchant:  : ${it.productMerchant}")


                        product.add(
                            Products(
                                it.productId,
                                it.productName,
                                it.productImage,
                                it.productPrice,
                                it.productRatings,
                                it.productMerchant
                            )
                        )
                    }
                }
                thread.start()

                val adapter = ProductAdapter(product, this@MainActivity)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()


                return true
            }
            R.id.amazon -> {
                Toast.makeText(this, "Amazon", Toast.LENGTH_SHORT).show()
                if (product.size != null) {
                    product.clear()
                }


                val thread = Thread {
                    DatabaseInstance?.bookDao()?.searchRecord("Amazon")?.forEach()
                    {
                        Log.i("Fetch Records", "Id:  : ${it.productId}")
                        Log.i("Fetch Records", "Name:  : ${it.productName}")
                        Log.i("Fetch Records", "Image:  : ${it.productImage}")
                        Log.i("Fetch Records", "Price:  : ${it.productPrice}")
                        Log.i("Fetch Records", "Ratings:  : ${it.productRatings}")
                        Log.i("Fetch Records", "Merchant:  : ${it.productMerchant}")

                        //  product!!.add(Products(it.productId,it.productName,it.productImage,it.productPrice,it.productRatings,it.productMerchant))

                        product.add(
                            Products(
                                it.productId,
                                it.productName,
                                it.productImage,
                                it.productPrice,
                                it.productRatings,
                                it.productMerchant
                            )
                        )
                    }
                }
                thread.start()


                val adapter = ProductAdapter(product, this@MainActivity)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()


                return true
            }
            R.id.shopclues -> {
                Toast.makeText(this, "ShopClues", Toast.LENGTH_SHORT).show()
                if (product.size != null) {
                    product.clear()
                }

                val thread = Thread {
                    DatabaseInstance?.bookDao()?.searchRecord("Shopclues")?.forEach()
                    {
                        Log.i("Fetch Records", "Id:  : ${it.productId}")
                        Log.i("Fetch Records", "Name:  : ${it.productName}")
                        Log.i("Fetch Records", "Image:  : ${it.productImage}")
                        Log.i("Fetch Records", "Price:  : ${it.productPrice}")
                        Log.i("Fetch Records", "Ratings:  : ${it.productRatings}")
                        Log.i("Fetch Records", "Merchant:  : ${it.productMerchant}")

                        //  product!!.add(Products(it.productId,it.productName,it.productImage,it.productPrice,it.productRatings,it.productMerchant))

                        product.add(
                            Products(
                                it.productId,
                                it.productName,
                                it.productImage,
                                it.productPrice,
                                it.productRatings,
                                it.productMerchant
                            )
                        )
                    }
                }
                thread.start()

                val adapter = ProductAdapter(product, this@MainActivity)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()


                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkAndRequestPermissions(): Boolean {
        val camerapermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val writepermission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)


        val listPermissionsNeeded = ArrayList<String>()

        if (camerapermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (writepermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        Log.d(TAG, "Permission callback called-------")
        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                val perms = HashMap<String, Int>()
                // Initialize the map with both permissions
                perms[Manifest.permission.CAMERA] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] =
                    PackageManager.PERMISSION_GRANTED

                // Fill with actual results from user
                if (grantResults.size > 0) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]
                    // Check for both permissions
                    if (perms[Manifest.permission.CAMERA] == PackageManager.PERMISSION_GRANTED
                        && perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED
                    ) {

                    } else {
                        Log.d(TAG, "Some permissions are not granted ask again ")

                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.CAMERA
                            )
                            || ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                            )
                        ) {
                            showDialogOK("Camera and Storage Permissions are required for this app",
                                DialogInterface.OnClickListener { dialog, which ->
                                    when (which) {
                                        DialogInterface.BUTTON_POSITIVE -> checkAndRequestPermissions()
                                        DialogInterface.BUTTON_NEGATIVE ->
                                            // proceed with logic by disabling the related features or quit the app.
                                            finish()
                                    }
                                })
                        } else {
                            explain("You need to give Camera and Storage permissions to continue. Do you want to go to app settings?")
                        }
                    }
                }
            }
        }

    }

    private fun showDialogOK(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", okListener)
            .create()
            .show()
    }

    private fun explain(msg: String) {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(this)
        dialog.setMessage(msg)
            .setPositiveButton("Yes") { paramDialogInterface, paramInt ->
                //  permissionsclass.requestPermission(type,code);
                startActivity(
                    Intent(
                        android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:com.boominathan.task")
                    )
                )
            }
            .setNegativeButton("Cancel") { paramDialogInterface, paramInt -> finish() }
        dialog.show()
    }

    companion object {

        val REQUEST_ID_MULTIPLE_PERMISSIONS = 1
        private val IMAGE_DIRECTORY = "/ProductsGallery"
    }

    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(this@MainActivity)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf("Select photo from gallery", "Capture photo from camera")
        pictureDialog.setItems(
            pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }

    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, GALLERY)
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart")
    }

    private fun takePhotoFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(
                intent,
                CAMERA
            );
        }


    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_CANCELED && data != null) {
            if (requestCode == GALLERY && resultCode == Activity.RESULT_OK && data != null) {
                var contentURI = data!!.data
                try {
                    var bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    path = saveImage(bitmap)

                    imageview!!.setImageBitmap(bitmap)

                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        if (resultCode != Activity.RESULT_CANCELED && data != null) {
            if (requestCode == CAMERA && resultCode == Activity.RESULT_OK && data != null) {

                try {
                    var thumbnail = data!!.extras!!.get("data") as Bitmap
                    imageview!!.setImageBitmap(thumbnail)
                    path = saveImage(thumbnail)

                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    fun saveImage(myBitmap: Bitmap): String {
        val bytes = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File(
            (Environment.getExternalStorageDirectory()).toString() + IMAGE_DIRECTORY
        )

        if (!wallpaperDirectory.exists()) {

            wallpaperDirectory.mkdirs()
        }

        try {
            val f = File(
                wallpaperDirectory, ((Calendar.getInstance()
                    .getTimeInMillis()).toString() + ".jpg")
            )
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            MediaScannerConnection.scanFile(
                this,
                arrayOf(f.getPath()),
                arrayOf("image/jpeg"), null
            )
            fo.close()
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath())

            return f.getAbsolutePath()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }

        return ""
    }

    private inner class GetUsersAsyncTask : AsyncTask<Void, Void, List<BookEntity>>() {
        override fun doInBackground(vararg url: Void): List<BookEntity>? {
            return DatabaseInstance?.bookDao()?.getAllBooks()
        }
    }

}
