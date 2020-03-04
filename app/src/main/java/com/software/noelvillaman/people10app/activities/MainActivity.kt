package com.software.noelvillaman.people10app.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.software.noelvillaman.people10app.R
import com.software.noelvillaman.people10app.classes.MarginCustomDecorator
import com.software.noelvillaman.people10app.classes.StoreAdapter
import com.software.noelvillaman.people10app.model.Stores
import com.software.noelvillaman.people10app.model.StoresDetail
import com.software.noelvillaman.people10app.networking.StoreService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var mAdater : StoreAdapter? = null

    lateinit var dataList : ArrayList<StoresDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        dataList = ArrayList()

        storeNetwork()

    }

    private fun storeNetwork(){
        val okHttpClient = OkHttpClient.Builder()
        val loggin = HttpLoggingInterceptor()
        loggin.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(loggin)

        //val okHttpClient: OkHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient()
        val plazaRetrofit = Retrofit.Builder()
            .baseUrl("http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()

        val api = plazaRetrofit.create(StoreService::class.java)
        val call = api.getStoresDetail()

        call.enqueue(object : Callback<Stores> {
            override fun onResponse(call: Call<Stores>, response: Response<Stores>) {
                if (response != null && response.isSuccessful){
                    response.body().toString()

                    var listData = response.body()!!.data
                    listData?.let { generateDataPlaza(it) }
                    val arreAdat = listData?.let {
                        ArrayAdapter<StoresDetail>(
                            applicationContext,
                            R.layout.main_layout,
                            it
                        )
                    }
                }
            }

            override fun onFailure(call: Call<Stores>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun generateDataPlaza(storeObjects : List<StoresDetail>){
        recyclerView = findViewById(R.id.store_list)
        mAdater = StoreAdapter(this, storeObjects)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        if (layoutManager != null){
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = mAdater
            recyclerView!!.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            recyclerView!!.addItemDecoration(MarginCustomDecorator(20))
        }
    }

}
