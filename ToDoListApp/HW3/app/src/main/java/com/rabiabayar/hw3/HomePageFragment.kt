package com.rabiabayar.hw3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.rabiabayar.hw3.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {

private lateinit var binding: FragmentHomePageBinding

@SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomePageBinding.inflate(inflater,container,false)

        binding.button.setOnClickListener{
            Navigation.findNavController(requireView()).navigate(R.id.action_homePageFragment_to_firstPageFragment)
        }
        return binding.root
    }
}