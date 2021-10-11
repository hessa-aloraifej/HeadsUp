package com.example.headsup

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
     private var retrofit: Retrofit? = null

   fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("https://dojo-recipes.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}



// client
// private var retrofit: Retrofit? = null
//
//    fun getClient(): Retrofit? {
//        retrofit = Retrofit.Builder()
//            .baseUrl("https://dojo-recipes.herokuapp.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        return retrofit
//    }

// interface
// @GET("/test")
//    fun getUsers() : Call<List<UserDetailsItem>>
//
//    @POST("/test/")
//    fun addUsers(@Body userData:UserDetailsItem): Call<UserDetailsItem>
//
//    @PUT("/test/{pk}")
//    fun updateUser(@Path("pk")pk:Int, @Body userData:UserDetailsItem): Call<UserDetailsItem>
//
//    @DELETE("/test/{pk}")
//    fun deleteUser(@Path("pk")pk:Int):Call<Void>

//adapter
// (val list: List<UserDetailsItem>) : RecyclerView.Adapter<UsersRVAdpater.ItemViewHolder>() {
//    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        return ItemViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.item_row,
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val user = list[position]
//
//        holder.itemView.apply {
//            textView3.text = " ID: ${user.pk}"
//            textView.text = " Name: ${user.name}"
//            textView2.text =" Location: ${user.location}"
//        }
//    }
//
//    override fun getItemCount(): Int = list.size
//}