package com.rabiabayar.hw3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val itemList: List<Item>, private val onItemDelete: (Int) -> Unit) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val deleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
        val itemCheckbox: CheckBox = itemView.findViewById(R.id.itemCheckbox)

        init {
            // Çöp kutusu simgesine tıklama olayı
            deleteIcon.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemDelete(position)
                }
            }

            // Checkbox'a tıklama olayı
            itemCheckbox.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // `item.isChecked` durumunu değiştirin
                    val item = itemList[position]
                    item.isChecked = !item.isChecked
                    // `itemCheckbox.isChecked`'i güncelleyin
                    itemCheckbox.isChecked = item.isChecked
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = itemList[position]
        holder.titleTextView.text = item.title
        holder.descriptionTextView.text = item.description

        // Checkbox durumunu `item.isChecked` ile eşleştirin
        holder.itemCheckbox.isChecked = item.isChecked
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
