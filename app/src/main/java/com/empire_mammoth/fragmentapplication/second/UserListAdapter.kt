package com.empire_mammoth.fragmentapplication.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.empire_mammoth.fragmentapplication.databinding.UserItemBinding
import com.empire_mammoth.fragmentapplication.second.UserListAdapter.UserItemHolder
import com.squareup.picasso.Picasso

class UserListAdapter(
    private val userListAdapterListener: UserListAdapterListener
) : RecyclerView.Adapter<UserItemHolder>() {

    private val userList = listOf(
        User(
            FirstName = "Галина",
            LastName = "Яльцева",
            Phone = "+7 980 728 92 28",
            url = "https://images.generated.photos/Cijh8wBZjguImTM0OI3Cm_FwAsY3GPbJloy5cYD6cxU/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92Ml8w/MTE0NDk5LmpwZw.jpg"
        ),User(
            FirstName = "Гавриил",
            LastName = "Карюгин",
            Phone = "+7 959 506 10 66",
            url = "https://images.generated.photos/avok3aH8Fvqde6mYQZW8p4aORYP_7W9W7aCBxkA5tI8/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/ODkyMTUyLmpwZw.jpg"
        ),User(
            FirstName = "Антон",
            LastName = "Зиновьев",
            Phone = "+7 926 885 36 39",
            url = "https://images.generated.photos/Z9tbjjPVUVuBP5R0wYxOwhplq1ZNa3jThQ3EQjfh4lY/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MjkwMTU4LmpwZw.jpg"
        ),User(
            FirstName = "Валений",
            LastName = "Новоселов",
            Phone = "+7 999 872 47 88",
            url = "https://images.generated.photos/iQqc4KpqOQPDgOpaNLeQgUSzg3tEPxhKEkFziO-v8l8/rs:fit:256:256/czM6Ly9pY29uczgu/Z3Bob3Rvcy1wcm9k/LnBob3Rvcy92M18w/MTkzODQ3LmpwZw.jpg"
        )
    )

    class UserItemHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) = with(binding) {
            val fullName = user.FirstName + " " + user.LastName
            textViewName.text = fullName
            textViewPhone.text = user.Phone
            Picasso.get()
                .load(user.url)
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
    }
}

interface UserListAdapterListener {
    fun onClickItem(holder: UserItemHolder)
}
