package com.example.mytaskbeunique.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytaskbeunique.R
import com.example.mytaskbeunique.model.DataY

class CustomAdapter(
    private var context: Context,
    private var interestList: List<DataY>
) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val interestImage = interestList[position]
        Glide.with(holder.propertyImage).load(interestImage.url).centerCrop()
            .into(holder.propertyImage)

    }

    override fun getItemCount(): Int {
        return interestList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var propertyImage: ImageView = itemView.findViewById(R.id.imageView_intrest)


    }
}



