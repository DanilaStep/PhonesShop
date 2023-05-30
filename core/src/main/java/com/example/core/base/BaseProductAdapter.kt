package com.example.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

abstract class BaseProductAdapter<T: Any, VB: ViewBinding>(diffUtil: DiffUtil.ItemCallback<T>):
        ListAdapter<T, BaseProductAdapter<T,VB>.ViewHolder>(diffUtil){

           abstract fun getBinding(
               inflater: LayoutInflater,
               container: ViewGroup?,
               viewType: Int
           ): VB
           abstract fun bindViewHolder(holder: ViewHolder, data: T)

           override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(getBinding(LayoutInflater.from(parent.context), parent, viewType))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = currentList[position]
        bindViewHolder(holder, element)
    }

    inner class ViewHolder(var binding: VB) : RecyclerView.ViewHolder(binding.root)
}