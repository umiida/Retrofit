package com.solve.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.solve.retrofit.model.AndroidClass
import kotlinx.android.synthetic.main.item.view.*

class AndroidAdapter: RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>(){
    inner class AndroidViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populateModel(model: AndroidClass?){
            itemView.tvItem.text = model?.name
        }
    }

    var models: List<AndroidClass>? = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return AndroidViewHolder(itemView)
    }

    override fun getItemCount(): Int = models?.size ?: 0
    override fun onBindViewHolder(holder: AndroidViewHolder, position: Int) {
        holder.populateModel(models?.get(position))
    }
}