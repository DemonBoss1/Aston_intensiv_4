package com.empire_mammoth.fragmentapplication.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.empire_mammoth.fragmentapplication.R


class UserInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = UserInfoFragment()
    }
}