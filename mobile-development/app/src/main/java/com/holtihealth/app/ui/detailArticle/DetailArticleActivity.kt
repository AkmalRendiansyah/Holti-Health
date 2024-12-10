package com.holtihealth.app.ui.detailArticle

import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.holtihealth.app.MyApplication
import com.holtihealth.app.R
import com.holtihealth.app.ViewModelFactory
import com.holtihealth.app.database.Article
import com.holtihealth.app.database.ArticleRepository
import com.holtihealth.app.databinding.ActivityDetailArticleBinding
import com.holtihealth.app.ui.scan.ResultViewModel

class DetailArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailArticleBinding

    private val myApplication by lazy {
        application as? MyApplication ?: throw IllegalStateException("Application is not an instance of MyApplication")
    }

    private val detailArticleViewModel: DetailArticleViewModel by lazy {
        val articleId = intent.getIntExtra("ARTICLE_ID", 0)
        ViewModelProvider(
            this,
            ViewModelFactory(articleRepository = myApplication.articleRepository, articleId = articleId)
        )[DetailArticleViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        detailArticleViewModel.getdetail.observe(this) { article ->
            article?.let { displayStoryDetails(it) }
        }

    }
    private fun displayStoryDetails(article: Article) {

        val descriptionText = Html.fromHtml(article.description, Html.FROM_HTML_MODE_COMPACT)
        binding.descriptionText.text = descriptionText
        binding.name.text = article.title

        Glide.with(this)
            .load(article.image)
            .into(binding.detailImageView)
    }
}