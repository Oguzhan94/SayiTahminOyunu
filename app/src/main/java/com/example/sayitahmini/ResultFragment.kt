package com.example.sayitahmini

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sayitahmini.databinding.FragmentGameBinding
import com.example.sayitahmini.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)

        init()

        return binding.root
    }

    private fun init(){
        getResult()
        playGame()
    }
    private fun getResult(){
        val bundle: ResultFragmentArgs by navArgs()
        val result = bundle.gameResult

        if (result){
            binding.textViewResult.setText(R.string.win)
            binding.imageViewResult.setImageResource(R.drawable.happy_face)
        }
        else{
            binding.textViewResult.setText(R.string.lose)
            binding.imageViewResult.setImageResource(R.drawable.sad_face)
        }
    }
    private fun playGame(){
        binding.buttonTryAgain.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment2_to_mainFragment)
        }
    }

}