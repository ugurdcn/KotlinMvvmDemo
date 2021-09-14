package com.zeygame.kotlinrecipedemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.zeygame.kotlinrecipedemo.R
import com.zeygame.kotlinrecipedemo.databinding.FragmentDetailsBinding
import com.zeygame.kotlinrecipedemo.model.Movy
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding : FragmentDetailsBinding?=null
    private val binding get() = _binding!!

    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var movie : Movy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movie = args.movie
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            txTitleDetail.text = movie.title
            txActors.text= movie.actors
            txPlot.text = movie.plot
            txDirector.text = movie.director
            txYear.text = movie.year
            imgDetail.load(movie.posterUrl){
                crossfade(true)
                crossfade(1000)
            }

            btnReferans.setOnClickListener {mView->
                val direction = DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(movie)
                mView.findNavController().navigate(direction)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }


}