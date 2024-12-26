package com.empire_mammoth.fragmentapplication.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.empire_mammoth.fragmentapplication.databinding.FragmentUserInfoBinding

const val UserInfoRequest = "UserInfoRequest"

class UserInfoFragment : Fragment() {
    private lateinit var binding: FragmentUserInfoBinding
    private var id: Int? = null
    private var firstName: String? = null
    private var lastName: String? = null
    private var phone: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInfoBinding.inflate(inflater)

        setFragmentResultListener(UserInfoRequest) { _, bundle ->

            id = bundle.getInt("Id")
            firstName = bundle.getString("FirstName")
            lastName = bundle.getString("LastName")
            phone = bundle.getString("Phone")

            binding.apply {
                editTextFirstName.setText(firstName ?: "")
                editTextTextLastName.setText(lastName ?: "")
                editTextTextPhone.setText(phone ?: "")
            }

        }



        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = UserInfoFragment()
    }
}