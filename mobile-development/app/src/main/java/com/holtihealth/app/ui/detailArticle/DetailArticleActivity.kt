package com.holtihealth.app.ui.detailArticle

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.holtihealth.app.MyApplication
import com.holtihealth.app.R
import com.holtihealth.app.database.Article
import com.holtihealth.app.database.ArticleRepository
import com.holtihealth.app.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailArticleBinding
    private lateinit var detailArticleViewModel: DetailArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val articleId = intent.getIntExtra("ARTICLE_ID", 0)
        val repository = (application as MyApplication).articelRepository
        detailArticleViewModel = ViewModelProvider(this, object : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(DetailArticleViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return DetailArticleViewModel(repository, articleId) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        })[DetailArticleViewModel::class.java]


        detailArticleViewModel.getdetail.observe(this) { article ->
            article?.let { displayStoryDetails(it) }
        }

    }
    private fun displayStoryDetails(article: Article) {
   //     binding.controlText.text = article.solusion
        binding.descriptionText.text = article.description
        binding.name.text = article.title
  //      binding.gejalaText.text = article.symptoms
 //       binding.penyebabText.text = article.cause


        Glide.with(this)
            .load(article.image)
            .into(binding.detailImageView)
    }
}