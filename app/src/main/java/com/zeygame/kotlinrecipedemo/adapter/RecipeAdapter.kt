package com.zeygame.kotlinrecipedemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zeygame.kotlinrecipedemo.databinding.FragmentDetailsBinding
import com.zeygame.kotlinrecipedemo.databinding.ReceipeAdapterLayoutBinding
import com.zeygame.kotlinrecipedemo.model.Movy
import com.zeygame.kotlinrecipedemo.view.DetailsFragmentDirections
import com.zeygame.kotlinrecipedemo.view.HomeFragmentDirections

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding:ReceipeAdapterLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){

    }
    private val diffCallback = object : DiffUtil.ItemCallback<Movy>(){
        override fun areItemsTheSame(oldItem: Movy, newItem: Movy): Boolean {
            return  oldItem.title==oldItem.title
        }

        override fun areContentsTheSame(oldItem: Movy, newItem: Movy): Boolean {
            return oldItem==newItem
        }
    }
    private val differ = AsyncListDiffer(this,diffCallback)
    var recipe: List<Movy>
        get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ReceipeAdapterLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currReceipe = recipe[position]
        holder.binding.apply {
            txTitleRow.text = currReceipe.title
            imgRow.load(currReceipe.posterUrl){
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener{mView->
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(currReceipe)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount()=recipe.size
}