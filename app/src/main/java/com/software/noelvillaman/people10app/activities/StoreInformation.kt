package com.software.noelvillaman.people10app.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.software.noelvillaman.people10app.R
import com.software.noelvillaman.people10app.model.StoresDetail
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_store_information.*
import kotlinx.android.synthetic.main.content_store_information.*

class StoreInformation : AppCompatActivity() {
    lateinit var mStoreDetail : StoresDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_information)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val mExtras = intent.extras!!
        //store_name.text = mExtras.getString("name")


        mStoreDetail = mExtras.getParcelable("storeDetail")!!

        store_name.text = mStoreDetail.name

        Picasso.get().load(mStoreDetail.storeLogoURL.toString()).resize(350, 500).centerInside().into(imageView_store);

        textView_store.text = "${mStoreDetail.address},\n ${mStoreDetail.city}, ${mStoreDetail.state} ${mStoreDetail.zipcode}"

        phonenumber.text = mStoreDetail.phone

        location_url.text = "${mStoreDetail.latitude}  ${mStoreDetail.longitude}"

        storeid.text = mStoreDetail.storeID

        title = mStoreDetail.name
    }



}
