package com.empire_mammoth.fragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.empire_mammoth.fragmentapplication.databinding.FragmentBBinding


class BFragment : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater)

        binding.buttonFragmentBA.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.buttonFragmentBC.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main, CFragment.newInstance())
                .addToBackStack("C Fragment")
                .commit()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = BFragment()
    }
}