package com.zeygame.kotlinrecipedemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.zeygame.kotlinrecipedemo.R
import com.zeygame.kotlinrecipedemo.adapter.RecipeAdapter
import com.zeygame.kotlinrecipedemo.databinding.FragmentHomeBinding
import com.zeygame.kotlinrecipedemo.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel:RecipeViewModel by viewModels()
    private lateinit var recipeAdapter: RecipeAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeAdapter = RecipeAdapter()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = recipeAdapter
        }
        viewModel.recipeResponse.observe(requireActivity(),{response->
            recipeAdapter.recipe = response.movies
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }
}