package com.miu.student.mycv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.student.mycv.data.ContactItem
import com.miu.student.mycv.data.ListItem
import com.miu.student.mycv.databinding.ContactItemBinding
import com.miu.student.mycv.databinding.ListItemBinding

class ContactItemAdapter(var listData:ArrayList<ContactItem>) : RecyclerView.Adapter<ContactItemAdapter.ItemHolder>() {
    private var context: Context? = null
    var onItemClick: ((ContactItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        context = parent.context
        val itemBinding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val listItem = listData[position]
        holder.bind(listItem)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ItemHolder(private val item: ContactItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(listItem: ContactItem) {
            item.title.text = listItem.value
            item.subTitle.text = listItem.type.name
            item.image.setImageResource(listItem.image)
            itemView.setOnClickListener { v: View? ->
                if (onItemClick != null) {
                        onItemClick!!.invoke(listItem)
                }
            }
        }
    }

}
