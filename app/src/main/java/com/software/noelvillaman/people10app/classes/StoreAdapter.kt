package com.software.noelvillaman.people10app.classes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.software.noelvillaman.people10app.R
import com.software.noelvillaman.people10app.activities.StoreInformation
import com.software.noelvillaman.people10app.model.StoresDetail
import com.squareup.picasso.Picasso

class StoreAdapter(private val mContext : Context, private val mainList: List<StoresDetail>) : RecyclerView.Adapter<StoreAdapter.CustomViewHolder>() {

    override fun getItemCount() = mainList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val mPosition = mainList[position]
        holder.sPhone.text = "Phone: ${mainList[position].phone}"
        holder.sAddress.text = "Address: ${mainList[position].address}\n${mainList[position].city}, ${mainList[position].state} ${mainList[position].zipcode}"
        Picasso.get().load(mainList[position].storeLogoURL).resize(150, 100).centerInside().into(holder.sLogo)

        holder.itemView.setOnClickListener({
            addStoreDetailToExtras(mainList[position])
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.main_layout, parent, false)
        return CustomViewHolder(view)

    }

    fun addStoreDetailToExtras(storesDetail: StoresDetail){
        val intentStores = Intent(mContext, StoreInformation::class.java)
        intentStores.putExtra("storeDetail", storesDetail)
        mContext.startActivity(intentStores)
    }

    inner class CustomViewHolder(mView : View) : RecyclerView.ViewHolder(mView){
        var sPhone : TextView
        var sAddress : TextView
        var sLogo : ImageView

        init {
            sPhone = mView.findViewById(R.id.phonenumber)
            sAddress = mView.findViewById(R.id.store_address)
            sLogo = mView.findViewById(R.id.storelogo)
        }
    }
}