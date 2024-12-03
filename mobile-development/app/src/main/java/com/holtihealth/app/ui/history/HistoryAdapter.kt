package com.holtihealth.app.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.holtihealth.app.database.History
import com.holtihealth.app.database.HistoryWithDisease
import com.holtihealth.app.databinding.ItemHistoryBinding

class HistoryAdapter(private  val onHistoryClick: (HistoryWithDisease) -> Unit) :
    ListAdapter<HistoryWithDisease, HistoryAdapter.HistoryViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyItem = getItem(position)
        holder.bind(historyItem)
        holder.itemView.setOnClickListener{
            onHistoryClick(historyItem)
        }

    }

    class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(historyWithDisease: HistoryWithDisease) {
            val history = historyWithDisease.history
            val disease = historyWithDisease.disease

            // Set disease name
            binding.diseaseName.text = disease.name

            // Set scan time
            binding.tvItemPublishedDate.text = history.scanTime

            // Set photo using Glide
            Glide.with(binding.root.context)
                .load(history.photoUri)
                .into(binding.photoUri)
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<HistoryWithDisease> =
            object : DiffUtil.ItemCallback<HistoryWithDisease>() {
                override fun areItemsTheSame(
                    oldItem: HistoryWithDisease,
                    newItem: HistoryWithDisease
                ): Boolean {
                    return oldItem.history.id == newItem.history.id
                }

                override fun areContentsTheSame(
                    oldItem: HistoryWithDisease,
                    newItem: HistoryWithDisease
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}
