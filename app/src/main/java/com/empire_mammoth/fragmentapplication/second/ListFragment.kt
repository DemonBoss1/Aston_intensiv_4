package com.empire_mammoth.fragmentapplication.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import com.empire_mammoth.fragmentapplication.R
import com.empire_mammoth.fragmentapplication.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)

        binding.apply {
            recyclerList.layoutManager = LinearLayoutManager(activity)
            recyclerList.adapter = UserListAdapter(object : UserListAdapterListener {
                override fun onClickItem(holder: UserListAdapter.UserItemHolder) {
                    setFragmentResult(UserInfoRequest, bundleOf(
                        "FirstName" to (holder.userInfo?.FirstName),
                        "LastName" to (holder.userInfo?.LastName),
                        "Phone" to (holder.userInfo?.Phone)
                    ))

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.main, UserInfoFragment.newInstance())
                        .addToBackStack("UserInfoFragment")
                        .commit()
                }

            })
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}