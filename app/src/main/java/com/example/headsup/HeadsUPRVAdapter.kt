package com.example.headsup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class HeadsUPRVAdapter (val list: List<HeadsUpDetailsItem>) : RecyclerView.Adapter<HeadsUPRVAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = list[position]

        holder.itemView.apply {
            tvname.text = user.name
            tvtaboo1.text = user.taboo1
            tvtaboo2.text =user.taboo2
            tvtaboo3.text =user.taboo3
        }
    }

    override fun getItemCount(): Int = list.size
}

