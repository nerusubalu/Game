package com.example.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.game.databinding.FragmentEndGameBinding
import com.example.game.databinding.FragmentGameBinding

class EndGameFragment : Fragment() {

    private lateinit var binding: FragmentEndGameBinding
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_end_game, container, false)
        viewModelFactory = ScoreViewModelFactory(EndGameFragmentArgs.fromBundle(requireArguments()).score)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if(playAgain){
                findNavController().navigate(EndGameFragmentDirections.actionEndToGame())
                viewModel.onPlayAgainComplete()
            }
        })
        return binding.root
    }
}