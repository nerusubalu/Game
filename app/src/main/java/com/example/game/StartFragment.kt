package com.example.game

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.game.databinding.StartFragmentBinding

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: StartFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.start_fragment, container, false)
        binding.gameStartBtn.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartToGame())
        }
        return binding.root
    }
}