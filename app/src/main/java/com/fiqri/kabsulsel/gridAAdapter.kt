package com.fiqri.kabsulsel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class gridAAdapter(val listKab: ArrayList<Kabupaten>) : RecyclerView.Adapter<gridAAdapter.GridViewHolder>() {



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_grid_aadapter, viewGroup, false)
        return GridViewHolder(view)
    }



    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val (name, rank, photo, overview, identity) = listKab[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)


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





    override fun getItemCount(): Int {
        return listKab.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }


}