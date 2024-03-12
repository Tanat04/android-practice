package com.example.androidfinalpractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalpractice.databinding.ItemPhoneBinding
import com.example.androidfinalpractice.models.Phone

class PhoneListAdapter(private val phones: List<Phone>) :
    RecyclerView.Adapter<PhoneListAdapter.PhoneViewHolder>() {

    class PhoneViewHolder(val binding: ItemPhoneBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPhoneBinding.inflate(layoutInflater, parent, false)

        return PhoneViewHolder(binding)
    }

    override fun getItemCount(): Int = phones.size

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phones[position]

        holder.binding.tvProductName.text = phone.Product_Name
        holder.binding.tvBrand.text = phone.Brand
        holder.binding.tvPrice.text = phone.Price.toString()
    }
}