package ru.effectiv.mobile.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.effectiv.domain.model.flash_sale.FlashSaleX
import ru.effectiv.mobile.R

class FlashSaleAdapter(private val latestList: List<FlashSaleX>) :
    RecyclerView.Adapter<FlashSaleAdapter.FlashSaleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.flash_sale_item, parent, false)
        return FlashSaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val latestItem = latestList[position]
        holder.bind(latestItem)
    }

    override fun getItemCount() = latestList.size

    class FlashSaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val flashSaleImage: ImageView = itemView.findViewById(R.id.flash_sale_main_image)
        private val flashSaleCategory: TextView = itemView.findViewById(R.id.flash_sale_category)
        private val flashSaleDiscount: TextView = itemView.findViewById(R.id.flash_sale_discount)
        private val flashSaleName: TextView = itemView.findViewById(R.id.flash_sale_name)
        private val flashSalePrice: TextView = itemView.findViewById(R.id.flash_sale_price)

        @SuppressLint("SetTextI18n")
        fun bind(item: FlashSaleX) {
            itemView.apply {
                Glide.with(context).load(item.image_url).into(flashSaleImage)
                flashSaleCategory.text = item.category
                flashSaleDiscount.text = "${item.discount} % off"
                flashSaleName.text = item.name
                flashSalePrice.text = "${item.price}"

                this.setOnClickListener {
                    findNavController().navigate(R.id.action_nav_home_to_nav_page_2)
                }
            }
        }
    }
}
