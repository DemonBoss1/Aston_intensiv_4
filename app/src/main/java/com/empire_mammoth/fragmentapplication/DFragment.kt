package com.empire_mammoth.fragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.empire_mammoth.fragmentapplication.databinding.FragmentDBinding


class DFragment : Fragment() {
    private lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(inflater)

        binding.buttonFragmentAB.setOnClickListener {
            parentFragmentManager.popBackStack("B Fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = DFragment()
    }
}