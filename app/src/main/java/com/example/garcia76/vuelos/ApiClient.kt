package com.example.garcia76.vuelos

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiClient {
    @GET("/flightstatus")
    fun getGralStatus(): Observable<List<FlightData>>


    companion object {

        fun create(): ApiClient {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://devavaya.ddns.net/")
                    .build()

            return retrofit.create(ApiClient::class.java)

        }
    }

}