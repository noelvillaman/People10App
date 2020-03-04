package com.software.noelvillaman.people10app.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoresDetail() : Parcelable{
    @SerializedName("phone")
    @Expose
    var phone : String? = null

    @SerializedName("address")
    @Expose
    var address : String? = null

    @SerializedName("city")
    @Expose
    var city : String? = null

    @SerializedName("state")
    @Expose
    var state : String? = null

    @SerializedName("zipcode")
    @Expose
    var zipcode : String? = null

    @SerializedName("name")
    @Expose
    var name : String? = null

    @SerializedName("storeLogoURL")
    @Expose
    var storeLogoURL : String? = null

    @SerializedName("longitude")
    @Expose
    var longitude : String? = null

    @SerializedName("latitude")
    @Expose
    var latitude : String? = null

    @SerializedName("storeID")
    @Expose
    var storeID : String? = null

    constructor(parcel: Parcel) : this() {
        phone = parcel.readString()
        address = parcel.readString()
        city = parcel.readString()
        state = parcel.readString()
        zipcode = parcel.readString()
        name = parcel.readString()
        storeLogoURL = parcel.readString()
        longitude = parcel.readString()
        latitude = parcel.readString()
        storeID = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(phone)
        parcel.writeString(address)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(zipcode)
        parcel.writeString(name)
        parcel.writeString(storeLogoURL)
        parcel.writeString(longitude)
        parcel.writeString(latitude)
        parcel.writeString(storeID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoresDetail> {
        override fun createFromParcel(parcel: Parcel): StoresDetail {
            return StoresDetail(parcel)
        }

        override fun newArray(size: Int): Array<StoresDetail?> {
            return arrayOfNulls(size)
        }
    }
}
