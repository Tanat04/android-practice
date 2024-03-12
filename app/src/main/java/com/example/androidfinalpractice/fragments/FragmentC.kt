package com.example.androidfinalpractice.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidfinalpractice.databinding.FragmentCBinding

class FragmentC: Fragment() {
    private lateinit var view: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = FragmentCBinding.inflate(inflater, container, false)

        return view.root
    }
}