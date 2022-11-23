package com.miu.student.mycv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.student.mycv.data.ListItem
import com.miu.student.mycv.databinding.ListItemBinding

class ListItemAdapter( var listData:ArrayList<ListItem>) : RecyclerView.Adapter<ListItemAdapter.ItemHolder>() {
    private var context: Context? = null
    var onItemClick: ((ListItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        context = parent.context
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val listItem = listData[position]
        holder.bind(listItem)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ItemHolder(private val item: ListItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(listItem: ListItem) {
            item.title.text = listItem.title
            item.subTitle.text = listItem.subtitle
            item.image.setImageResource(listItem.image)
            item.time.text = listItem.time
            item.location.text = listItem.location
            // if description is empty, hide the text view
            // else show the showmore and truncate the text and add three dots
            if (listItem.description.isEmpty()) {
                item.description.visibility = View.GONE
                item.showMore.visibility = View.GONE
            } else {
                item.description.visibility = View.VISIBLE
                item.description.text = listItem.description.substring(0, 40) + "..."
                item.showMore.visibility = View.VISIBLE
                item.description.maxLines = 1
                item.showMore.setOnClickListener {
                    if (item.description.maxLines == 1) {
                        item.description.maxLines = 100
                        item.description.text = listItem.description
                        item.showMore.text = "Show Less"
                    } else {
                        item.description.maxLines = 1
                        item.showMore.text = "hide description"
                        item.description.text = listItem.description.substring(0, 40) + "..."
                        item.showMore.visibility = View.VISIBLE
                    }
                }
            }
            itemView.setOnClickListener { v: View? ->
                if (onItemClick != null) {
                        onItemClick!!.invoke(listItem)
                }
            }
        }
    }

}
