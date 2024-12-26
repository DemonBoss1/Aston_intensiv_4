package com.empire_mammoth.fragmentapplication.second

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.empire_mammoth.fragmentapplication.databinding.FragmentUserInfoBinding
import com.squareup.picasso.Picasso

const val UserInfoRequest = "UserInfoRequest"

class UserInfoFragment : Fragment() {
    private lateinit var binding: FragmentUserInfoBinding
    private var id: Int? = null
    private var firstName: String? = null
    private var lastName: String? = null
    private var phone: String? = null
    private var path: String? = null

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
            path = bundle.getString("Path")

            binding.apply {
                editTextFirstName.setText(firstName ?: "")
                editTextTextLastName.setText(lastName ?: "")
                editTextTextPhone.setText(phone ?: "")
                Picasso.get().load(path).into(binding.userAvatarImage)
            }

        }

        binding.apply {
            applyButton.setOnClickListener {
                firstName = editTextFirstName.text.toString()
                lastName = editTextTextLastName.text.toString()
                phone = editTextTextPhone.text.toString()

                setFragmentResult(
                    ListFragmentRequest, bundleOf(
                        "Id" to (id),
                        "FirstName" to (firstName),
                        "LastName" to (lastName),
                        "Phone" to (phone)
                    )
                )

                parentFragmentManager.popBackStack()
            }
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = UserInfoFragment()
    }
}