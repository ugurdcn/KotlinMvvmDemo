package com.zeygame.kotlinrecipedemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.zeygame.kotlinrecipedemo.R
import com.zeygame.kotlinrecipedemo.databinding.FragmentDetailsBinding
import com.zeygame.kotlinrecipedemo.databinding.FragmentWebViewBinding
import com.zeygame.kotlinrecipedemo.model.Movy


class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private var _binding : FragmentWebViewBinding?=null
    private val binding get() = _binding!!

    private val args: WebViewFragmentArgs by navArgs()
    private lateinit var  movie:Movy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWebViewBinding.inflate(inflater,container,false)

        return binding.root    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movie = args.movieWebView
        setUpWebView()
    }

    private fun setUpWebView() {
        binding.webView.apply {


        /// modele yönlendirme linki (href) ekleyip  sitelere yönlendirmek için kullanın
//          webViewClient = WebViewClient()
 //         loadUrl(movie.href)
        }
    }
}