package com.example.project_kbm.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_kbm.databinding.ItemEventBinding
import com.example.project_kbm.model.ModelEvent
import com.example.project_kbm.model.ModelNews

class EventsAdapter(val data: ArrayList<ModelEvent>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private class MyViewHolder (val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder (ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = data[position]

        if (holder is MyViewHolder) {
            holder.binding.ivPosterEvent.setImageResource(model.poster)
            holder.binding.tvNameEvent.text = model.name
            holder.binding.btnDirectLinkEvent.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(model.url)
                context.startActivity(intent)
            }

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
        fun onClick (position: Int, model: ModelEvent)
    }
}