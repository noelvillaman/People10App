package com.software.noelvillaman.people10app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Stores {
    @SerializedName("stores")
    @Expose
    var data : List<StoresDetail>?  = null
}