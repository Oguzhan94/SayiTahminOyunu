package com.example.sayitahmini

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sayitahmini.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private var rastgeleSayi = 0
    private var sayac = 5

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gamePlay()
    }


    private fun gamePlay() {

        rastgeleSayi = Random.nextInt(101)
        Log.e("sayi", rastgeleSayi.toString())
        binding.textView.text = "Kalan hakkınız: $sayac"
        binding.textView3.visibility = View.INVISIBLE
        binding.button2.setOnClickListener {
            sayac--
            binding.textView.text = "Kalan hakkınız: $sayac"
            if (sayac == 0) {
                var result = GameFragmentDirections.actionGameFragmentToResultFragment2(false)
                findNavController().navigate(result)
            } else {
                if (binding.editTextTextGuest.text.toString() < rastgeleSayi.toString()) {
                    binding.textView3.visibility = View.VISIBLE
                    binding.textView3.setText(R.string.raise_the_estimate)
                } else if (binding.editTextTextGuest.text.toString() > rastgeleSayi.toString()) {
                    binding.textView3.visibility = View.VISIBLE
                    binding.textView3.setText(R.string.reduce_estimate)
                } else {
                    var result = GameFragmentDirections.actionGameFragmentToResultFragment2(true)
                    findNavController().navigate(result)
                }
            }

        }

    }


}