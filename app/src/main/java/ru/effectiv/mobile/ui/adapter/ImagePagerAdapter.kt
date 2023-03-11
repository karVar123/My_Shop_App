package ru.effectiv.mobile.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import ru.effectiv.mobile.R


class ImagePagerAdapter(
    private val images: List<String>,
    private var selectedItemPosition: Int,
    private val mainImageView: ImageView,
) :
    RecyclerView.Adapter<ImagePagerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun changeSelectedItemPosition(newSelectedPosition: Int) {
        selectedItemPosition = newSelectedPosition
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.product_image)
        fun bind(imageUrl: String) {
            Glide.with(productImage).load(imageUrl).into(productImage)
            if (position == selectedItemPosition) {
                Glide.with(mainImageView).load(imageUrl).into(mainImageView)
                productImage.layoutParams.width =
                    productImage.context.resources.getDimension(R.dimen.product_selected_image_width)
                        .toInt()
                productImage.layoutParams.height =
                    productImage.context.resources.getDimension(R.dimen.product_selected_image_height)
                        .toInt()
                productImage.setPadding(0, 0, 0, 5)
            } else {
                productImage.layoutParams.width =
                    productImage.context.resources.getDimension(R.dimen.product_unselected_image_width)
                        .toInt()
                productImage.layoutParams.height =
                    productImage.context.resources.getDimension(R.dimen.product_unselected_image_height)
                        .toInt()
            }
            itemView.setOnClickListener {
                itemClick(imageUrl, position)
            }

        }

        @SuppressLint("NotifyDataSetChanged")
        private fun itemClick(imageUrl: String, position: Int) {
            changeSelectedItemPosition(position)
            Glide.with(mainImageView).load(imageUrl).into(mainImageView)
        }
    }
}
/*
class ImagePagerAdapter(
    private val images: ArrayList<String>,
    private val imageView: ImageView,
) :
    RecyclerView.Adapter<ImagePagerAdapter.ViewHolder>() {
    private val runnable = Runnable {
        images.addAll(images)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])


    }

    override fun getItemCount(): Int {
        return images.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.product_image)
        fun bind(imageUrl: String) {
            Glide.with(productImage).load(imageUrl).into(productImage)
            productImage.setOnClickListener {
                Glide.with(imageView).load(imageUrl).into(imageView)
            }
        }
    }
}*/
