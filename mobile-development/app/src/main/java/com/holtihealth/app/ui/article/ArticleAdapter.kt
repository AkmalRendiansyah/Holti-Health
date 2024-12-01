package com.holtihealth.app.ui.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.holtihealth.app.database.Article
import com.holtihealth.app.databinding.ItemarticleBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val articles = ArrayList<Article>()

    fun setArticles(newArticles: List<Article>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemarticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    class ArticleViewHolder(private val binding: ItemarticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description

            // Load image with Glide
            Glide.with(binding.root.context)
                .load(article.image) // URL gambar dari database
                .into(binding.ivArticle)
        }
    }
}
