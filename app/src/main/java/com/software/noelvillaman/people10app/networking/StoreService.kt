package com.software.noelvillaman.people10app.networking

import com.software.noelvillaman.people10app.model.Stores
import com.software.noelvillaman.people10app.model.StoresDetail
import retrofit2.Call
import retrofit2.http.GET

interface StoreService {
    @GET("stores.json")
    fun getStoresDetail() : Call<Stores>
}