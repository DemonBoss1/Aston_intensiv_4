package com.empire_mammoth.fragmentapplication.second

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.empire_mammoth.fragmentapplication.databinding.FragmentUserInfoBinding

const val UserInfoRequest = "UserInfoRequest"

class UserInfoFragment : Fragment() {
    private lateinit var binding: FragmentUserInfoBinding
    private var FirstName: String? = null
    private var LastName: String? = null
    private var Phone: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInfoBinding.inflate(inflater)

        setFragmentResultListener(UserInfoRequest) { _, bundle ->

                FirstName = bundle.getString("FirstName")
                LastName = bundle.getString("LastName")
                Phone = bundle.getString("Phone")

            binding.apply {
                editTextFirstName.setText(FirstName ?: "")
                editTextTextLastName.setText(LastName ?: "")
                editTextTextPhone.setText(Phone ?: "")
            }

        }



        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = UserInfoFragment()
    }
}