package com.empire_mammoth.fragmentapplication.second

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.empire_mammoth.fragmentapplication.R
import com.empire_mammoth.fragmentapplication.databinding.FragmentListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


const val ListFragmentRequest = "ListFragmentRequest"

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private var userList = listOf(
        User(
            firstName = "Галина",
            lastName = "Яльцева",
            phone = "+7 980 728 92 28",
            url = "https://images.generated.photos/Cijh8wBZjguImTM0OI3Cm_FwAsY3GPbJloy5cYD6cxU/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92Ml8w/MTE0NDk5LmpwZw.jpg"
        ), User(
            firstName = "Гавриил",
            lastName = "Карюгин",
            phone = "+7 959 506 10 66",
            url = "https://images.generated.photos/avok3aH8Fvqde6mYQZW8p4aORYP_7W9W7aCBxkA5tI8/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/ODkyMTUyLmpwZw.jpg"
        ), User(
            firstName = "Антон",
            lastName = "Зиновьев",
            phone = "+7 926 885 36 39",
            url = "https://images.generated.photos/Z9tbjjPVUVuBP5R0wYxOwhplq1ZNa3jThQ3EQjfh4lY/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MjkwMTU4LmpwZw.jpg"
        ), User(
            firstName = "Валерий",
            lastName = "Новоселов",
            phone = "+7 999 872 47 88",
            url = "https://images.generated.photos/iQqc4KpqOQPDgOpaNLeQgUSzg3tEPxhKEkFziO-v8l8/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MTkzODQ3LmpwZw.jpg"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)

        loadData()

        setFragmentResultListener(ListFragmentRequest) { _, bundle ->

            val id = bundle.getInt("Id")
            val firstName = bundle.getString("FirstName")
            val lastName = bundle.getString("LastName")
            val phone = bundle.getString("Phone")

            if (firstName != null && lastName != null && phone != null) {
                userList[id].firstName = firstName
                userList[id].lastName = lastName
                userList[id].phone = phone
            }
        }

        binding.apply {
            recyclerList.layoutManager = LinearLayoutManager(activity)
            recyclerList.adapter = UserListAdapter(userList, object : UserListAdapterListener {
                override fun onClickItem(holder: UserListAdapter.UserItemHolder) {
                    setFragmentResult(
                        UserInfoRequest, bundleOf(
                            "Id" to (holder.id),
                            "FirstName" to (holder.userInfo?.firstName),
                            "LastName" to (holder.userInfo?.lastName),
                            "Phone" to (holder.userInfo?.phone)
                        )
                    )

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.main, UserInfoFragment.newInstance())
                        .addToBackStack("UserInfoFragment")
                        .commit()
                }

            })
        }

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        saveData()
    }

    private fun saveData() {
        val sharedPreferences = activity?.getSharedPreferences("Save", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        val gson = Gson()
        val list = ArrayList(userList)
        val json = gson.toJson(list)
        editor?.putString("List", json)
        editor?.apply()
    }

    private fun loadData() {
        val sharedPreferences = activity?.getSharedPreferences("Save", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences?.getString("List", null)
        val type: Type = object : TypeToken<ArrayList<User?>?>() {}.type
        val list:ArrayList<User>? = gson.fromJson<Any>(json, type) as ArrayList<User>?
        if (list != null) userList = list.toList()
    }

    companion object {

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}