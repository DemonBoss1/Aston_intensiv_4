package com.empire_mammoth.fragmentapplication.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.empire_mammoth.fragmentapplication.databinding.UserItemBinding
import com.empire_mammoth.fragmentapplication.second.UserListAdapter.UserItemHolder
import com.squareup.picasso.Picasso

class UserListAdapter(
    private val userList: List<User>,
    private val userListAdapterListener: UserListAdapterListener
) : RecyclerView.Adapter<UserItemHolder>() {

    class UserItemHolder(
        private val binding: UserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var userInfo: User? = null
        var id: Int? = null

        fun bind(user: User) = with(binding) {
            userInfo = user
            val fullName = user.firstName + " " + user.lastName
            textViewName.text = fullName
            textViewPhone.text = user.phone
            Picasso.get()
                .load(user.path)
                .into(userAvatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        val holder = UserItemHolder(binding)
        binding.root.setOnClickListener {
            userListAdapterListener.onClickItem(holder)
        }
        return holder
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserItemHolder, position: Int) {
        holder.bind(userList[position])
        holder.id = position
    }
}

interface UserListAdapterListener {
    fun onClickItem(holder: UserItemHolder)
}
