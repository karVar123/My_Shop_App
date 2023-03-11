package ru.effectiv.mobile.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.effectiv.mobile.R

class SuggestionsAdapter(
    private var suggestions: List<String>,
    private val searchView: EditText,
) : RecyclerView.Adapter<SuggestionsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.suggestion_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(suggestions[position])
    }

    override fun getItemCount() = suggestions.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val suggestionText: TextView = itemView.findViewById(R.id.suggestion_text)
        fun bind(suggestions: String) {
            suggestionText.text = suggestions
            Log.e("ADAPTER", "bind: suggestion")
            itemView.setOnClickListener {
                searchView.setText(suggestions)
            }
        }
    }

    fun setFilteredList(filteredList: List<String>) {
        suggestions = filteredList
        notifyDataSetChanged()

    }
}