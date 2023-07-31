package com.example.newsmvvmapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsmvvmapplication.R
import com.example.newsmvvmapplication.adapter.NewsAdapter
import com.example.newsmvvmapplication.ui.MainActivity
import com.example.newsmvvmapplication.ui.NewViewModel


class BreakingFragment : Fragment() {
    lateinit var viewModel: NewViewModel
    lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breaking, container, false)
        viewModel=(activity as MainActivity).newViewModel
    }
    private fun setUpRecyclerView(){
        newsAdapter = NewsAdapter()


    }
}