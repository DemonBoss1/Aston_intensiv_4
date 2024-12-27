package com.empire_mammoth.fragmentapplication.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.empire_mammoth.fragmentapplication.R
import com.empire_mammoth.fragmentapplication.databinding.FragmentBBinding


class BFragment : Fragment() {

    private lateinit var binding: FragmentBBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater)

        binding.buttonFragmentBA.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.buttonFragmentBC.setOnClickListener {
            dataModel.message.value = "Hello Fragment C"

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