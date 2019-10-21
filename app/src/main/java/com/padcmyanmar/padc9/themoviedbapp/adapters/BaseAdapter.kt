package com.padcmyanmar.padc9.themoviedbapp.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padc9.themoviedbapp.viewholders.BaseViewHolder

abstract class BaseAdapter<VH: BaseViewHolder<T>, T>: RecyclerView.Adapter<VH>() {
    var data: MutableList<T> = ArrayList()

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = data[position]
    }

    fun setNewData(newData: MutableList<T>) {
        data = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: MutableList<T>) {
        data.addAll(newData)
    }
}