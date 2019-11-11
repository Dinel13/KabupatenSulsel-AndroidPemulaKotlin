package com.fiqri.kabsulsel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAdapter(val listKab: ArrayList<Kabupaten>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_view, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listKab.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rank, photo, overview, identity) = listKab[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRank.text = rank

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailActivityt::class.java)
            moveDetail.putExtra(DetailActivityt.EXTRA_RANK, rank)
            moveDetail.putExtra(DetailActivityt.EXTRA_NAME, name)
            moveDetail.putExtra(DetailActivityt.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailActivityt.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(DetailActivityt.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRank: TextView = itemView.findViewById(R.id.tv_item_rank)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}