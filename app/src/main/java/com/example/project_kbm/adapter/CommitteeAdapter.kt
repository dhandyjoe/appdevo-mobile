package com.example.project_kbm.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_kbm.databinding.ItemCommitteeBinding
import com.example.project_kbm.model.ModelCommittee
import com.example.project_kbm.model.ModelEvent

class CommitteeAdapter(val data: ArrayList<ModelCommittee>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private class MyViewHolder (val binding: ItemCommitteeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder (ItemCommitteeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = data[position]

        if (holder is MyViewHolder) {
            holder.binding.tvCommittee.text = model.nameCommittee
            holder.binding.descCommittee.text = model.descCommittee
            holder.binding.btnDirectLinkCommittee.setOnClickListener {
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
        fun onClick (position: Int, model: ModelCommittee)
    }
}