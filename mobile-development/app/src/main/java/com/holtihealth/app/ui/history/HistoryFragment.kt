package com.holtihealth.app.ui.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.holtihealth.app.MyApplication
import com.holtihealth.app.ViewModelFactory
import com.holtihealth.app.databinding.FragmentHistoryBinding
import com.holtihealth.app.ui.detailHistory.DetailHistoryActivity

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val historyViewModel: HistoryViewModel by viewModels {
        ViewModelFactory(historyRepository = (requireActivity().application as MyApplication).historyRepository)
    }

    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyAdapter = HistoryAdapter { historyWithDisease ->
            val intent = Intent(context, DetailHistoryActivity::class.java)
            intent.putExtra("HISTORY_ID", historyWithDisease.history.id)
            startActivity(intent)
        }


        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter
        }

        // Observe LiveData
        historyViewModel.allHistoryWithDisease.observe(viewLifecycleOwner) { historyList ->
            if (historyList.isNullOrEmpty()) {
                // Show "No history" message
                binding.tvNoHistory.visibility = View.VISIBLE
                binding.rvHistory.visibility = View.GONE
            } else {
                // Hide "No history" message and show list
                binding.tvNoHistory.visibility = View.GONE
                binding.rvHistory.visibility = View.VISIBLE
                historyAdapter.submitList(historyList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
