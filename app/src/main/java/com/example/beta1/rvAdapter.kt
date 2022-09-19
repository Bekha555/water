package com.example.beta1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_finish.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class rvAdapter(private val listofNames: List<Water>) :
    RecyclerView.Adapter<rvAdapter.ItemHolder>() {
    var arrList = ArrayList<Water>()

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.saved_check
        val textView2: TextView = view.date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        val itemHolder = ItemHolder(view)
        return itemHolder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.textView.text = listofNames[position].title
        holder.textView2.text = listofNames[position].date
    }

    override fun getItemCount(): Int {
        return listofNames.size
    }
}