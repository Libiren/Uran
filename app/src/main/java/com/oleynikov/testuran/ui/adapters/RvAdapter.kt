package com.oleynikov.testuran.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.oleynikov.testuran.R
import com.oleynikov.testuran.data_classes.Exhibit
import kotlinx.android.synthetic.main.rv_item.view.*

class RvAdapter(val list: MutableList<Exhibit.Item>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.count()


    override fun onBindViewHolder(holder: ViewHolder, p1: Int) = holder.bind()


    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var context = view.context
        var tvTitle = view.tvTitle
        var llImage = view.llImage

        fun bind() {
            val item = list[layoutPosition]
            var params = LinearLayout.LayoutParams( 500,  500)
            params.setMargins(10, 10, 10, 10)
            tvTitle.text = item.title



            for(i in  item.images) {
                var image = ImageView(context)
                image.scaleType = ImageView.ScaleType.CENTER_CROP
                image.layoutParams = params
                llImage.addView(image)
                Glide.with(context).load(i).into(image)
            }

        }
    }
}