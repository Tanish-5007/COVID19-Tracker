package com.example.covid19_tracker

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.covid19_tracker.databinding.ItemListBinding

class StateAdapter(private val list: List<StatewiseItem>): BaseAdapter(){

    override fun getCount(): Int = list.size

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val binding = ItemListBinding.inflate(LayoutInflater.from(parent!!.context))

        val item = list[position]
        binding.confirmedTv.text = item.confirmed
        binding.recoveredTv.text = item.recovered
        binding.activeTv.text = item.active
        binding.deathTv.text = item.deaths
        binding.stateTv.text = item.state

        return binding.root

    }

}