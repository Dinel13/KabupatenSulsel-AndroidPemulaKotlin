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

class cardAdapter (private val listKab: ArrayList<Kabupaten>) : RecyclerView.Adapter<cardAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_adapter, parent, false)
        return CardViewHolder(view)
    }


    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, ibu , logo, overview, identity) = listKab[position]

        Glide.with(holder.itemView.context)
            .load(logo)
            .apply(RequestOptions())
            .into(holder.imglogo)

        holder.tvName.text = name
        holder.tvIbu.text = ibu
        holder.tvOver.text = overview

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailActivityt::class.java)
            moveDetail.putExtra(DetailActivityt.EXTRA_RANK, ibu)
            moveDetail.putExtra(DetailActivityt.EXTRA_NAME, name)
            moveDetail.putExtra(DetailActivityt.EXTRA_PHOTO, logo)
            moveDetail.putExtra(DetailActivityt.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(DetailActivityt.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }





    override fun getItemCount(): Int {
        return listKab.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imglogo: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvIbu: TextView = itemView.findViewById(R.id.ibukota)
        var tvOver: TextView = itemView.findViewById(R.id.tv_item_detail)

    }

}
