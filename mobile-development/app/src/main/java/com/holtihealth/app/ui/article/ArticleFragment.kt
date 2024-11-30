package com.holtihealth.app.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.holtihealth.app.R
import com.holtihealth.app.databinding.FragmentArticleBinding
import androidx.recyclerview.widget.LinearLayoutManager

class ArticleFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleFragment()
    }

    private val viewModel: ArticleViewModel by viewModels()
    private var _articleFragmentBinding: FragmentArticleBinding? = null
    private val binding get() = _articleFragmentBinding

    private lateinit var articleAdapter: ArticleAdapter // Assuming you have an adapter for RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // You can observe LiveData or perform other ViewModel-related tasks here
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _articleFragmentBinding = FragmentArticleBinding.inflate(inflater, container, false)

        // Set up RecyclerView
        binding?.rvArticle?.layoutManager = LinearLayoutManager(context)
        articleAdapter = ArticleAdapter() // Initialize your adapter here
        binding?.rvArticle?.adapter = articleAdapter

        // Observe data from ViewModel
        viewModel.getAllArticles().observe(viewLifecycleOwner, Observer { articles ->
            articles?.let {
                articleAdapter.setArticles(it)  // Update the adapter's data
            }
        })

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Avoid memory leaks by setting binding to null
        _articleFragmentBinding = null
    }
}
