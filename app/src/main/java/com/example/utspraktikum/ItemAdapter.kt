package com.example.utspraktikum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(
    private val mItems: List<Item>,
    private val mLayoutManager: GridLayoutManager) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    companion object {
        const val SPAN_COUNT_ONE = 1
        const val SPAN_COUNT_TWO = 2

        const val VIEW_TYPE_SMALL = 1
        const val VIEW_TYPE_BIG = 2
    }

    override fun getItemViewType(position: Int): Int {
        val spanCount = mLayoutManager.spanCount
        return if (spanCount == SPAN_COUNT_ONE)
            VIEW_TYPE_BIG else VIEW_TYPE_SMALL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_BIG) {
            val view = inflater.inflate(R.layout.item_linear, parent, false)
            ItemViewHolder(view, viewType)
        } else {
            val view = inflater.inflate(R.layout.item_grid, parent, false)
            ItemViewHolder(view, viewType)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = mItems[position]
        holder.title.text = item.getTitle()
        holder.iv.setImageResource(item.getImgResId())
        if (getItemViewType(position) == VIEW_TYPE_BIG) {
            holder.info?.text = " ${item.getLikes()}  \n  ${item.getComments()} tahun"
        } else {
            holder.info?.text = " ${item.getLikes()}  \n  ${item.getComments()} tahun"
        }
    }

    override fun getItemCount(): Int = mItems.size

    inner class ItemViewHolder
        (itemView: View, viewType: Int) :
        RecyclerView.ViewHolder(itemView) {
        val iv: ImageView
        val title: TextView
        val info: TextView?

        init {
            if (viewType == VIEW_TYPE_BIG) {
                iv = itemView.findViewById(R.id.image_big)
                title = itemView.findViewById(R.id.title_big)
                info = itemView.findViewById(R.id.tv_info)
            } else {
                iv = itemView.findViewById(R.id.image_small)
                title = itemView.findViewById(R.id.title_small)
                info = itemView.findViewById(R.id.tv_info)
            }
        }
    }
}