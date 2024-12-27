package com.empire_mammoth.fragmentapplication.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.empire_mammoth.fragmentapplication.R
import com.empire_mammoth.fragmentapplication.databinding.FragmentABinding

class AFragment : Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater)

        binding.buttonFragmentAB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main, BFragment.newInstance())
                .addToBackStack("B Fragment")
                .commit()
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = AFragment()
    }
}