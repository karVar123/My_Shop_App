package ru.effectiv.mobile.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.effectiv.domain.model.latest.LatestX
import ru.effectiv.mobile.R

class LatestAdapter(
    private val latestList: List<LatestX>,
    private val fragmentManager: FragmentManager,
) :
    RecyclerView.Adapter<LatestAdapter.LatestViewHolder>() {

    class LatestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val latestImage: ImageView = itemView.findViewById(R.id.latest_image)
        private val latestCategory: TextView = itemView.findViewById(R.id.latest_category)
        private val latestName: TextView = itemView.findViewById(R.id.latest_name)
        private val latestPrice: TextView = itemView.findViewById(R.id.latest_price)
        fun bind(latestItem: LatestX, fragmentManager: FragmentManager) {
            itemView.apply {
                Glide.with(context)
                    .load(latestItem.image_url)
                    .into(latestImage);
                latestCategory.text = latestItem.category
                latestName.text = latestItem.name
                latestPrice.text = "$ ${latestItem.price}"
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.latest_item, parent, false)
        return LatestViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val latestItem = latestList[position]
        holder.bind(latestItem, fragmentManager)

    }

    override fun getItemCount() = latestList.size
}