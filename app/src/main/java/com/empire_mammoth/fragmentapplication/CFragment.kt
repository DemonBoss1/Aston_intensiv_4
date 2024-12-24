package com.empire_mammoth.fragmentapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.empire_mammoth.fragmentapplication.databinding.FragmentCBinding

class CFragment : Fragment() {
    private lateinit var binding: FragmentCBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater)

        dataModel.message.observe(activity as LifecycleOwner, {
binding.textFromFragmentC.text = it
        })
        binding.apply {
            buttonFragmentCA.setOnClickListener {
                parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            buttonFragmentCD.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, DFragment.newInstance())
                    .addToBackStack("D Fragment")
                    .commit()
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CFragment()
    }
}