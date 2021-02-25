package com.hanifkf12.myrecyclerapp1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanifkf12.myrecyclerapp1.model.Note
import com.hanifkf12.myrecyclerapp1.databinding.ListItemBinding

class MyAdapter(private val data : List<Note>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    lateinit var onClick: (Note) -> Unit

    fun setOnItemClickListener(onClick : (Note) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindViewHolder(note: Note){
            binding.root.setOnClickListener {
                onClick(note)
            }
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content
        }
    }
}