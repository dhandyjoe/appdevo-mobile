package com.example.project_kbm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_kbm.databinding.ItemNewsBinding
import com.example.project_kbm.model.ModelNews

class NewsAdapter(val data: ArrayList<ModelNews>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private class MyViewHolder (val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder (ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = data[position]

        if (holder is MyViewHolder) {
            holder.binding.tvName.text = model.name
            holder.binding.tvDate.text = model.date
            holder.binding.tvNameNews.text = model.nameNews
            holder.binding.tvCategory.text = model.nameCategory

            holder.itemView.setOnClickListener {
                onClickListener!!.onClick(position, model)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    // code for click listener
    private var onClickListener: OnClickListener? = null

    fun setOnClickListener (onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick (position: Int, model: ModelNews)
    }
}