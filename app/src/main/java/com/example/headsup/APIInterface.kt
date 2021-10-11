package com.example.headsup

import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @GET("/celebrities/")
    fun getUsers() : Call<List<HeadsUpDetailsItem>>

    @POST("/celebrities/")
    fun addUsers(@Body userData:HeadsUpDetailsItem): Call<HeadsUpDetailsItem>

    @PUT("/celebrities/{pk}")
    fun updateUser(@Path("pk")pk:Int, @Body userData:HeadsUpDetailsItem): Call<HeadsUpDetailsItem>

    @DELETE("/celebrities/{pk}")
    fun deleteUser(@Path("pk")pk:Int):Call<Void>
}