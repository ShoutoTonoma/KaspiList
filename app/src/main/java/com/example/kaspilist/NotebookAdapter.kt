package com.example.kaspilist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kaspilist.databinding.NotebookItemBinding

class NotebookAdapter: RecyclerView.Adapter<NotebookAdapter.NotebookHolder>() {
    val noteBookList = ArrayList<Notebook>()
    class NotebookHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = NotebookItemBinding.bind(item)
        fun bind(notebook: Notebook) = with(binding){
            im.setImageResource(notebook.ImageId)
            tvTitle.text = notebook.title
            tvPrice.text = notebook.Price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotebookHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notebook_item, parent, false)
        return NotebookHolder(view)
    }

    override fun onBindViewHolder(holder: NotebookHolder, position: Int) {
        holder.bind(noteBookList[position])
    }

    override fun getItemCount(): Int {
        return noteBookList.size
    }

    fun addNotebook(notebook: Notebook){
        noteBookList.add(notebook)
        notifyDataSetChanged()
    }
}