package com.example.suitmedia_android_developer_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmedia_android_developer_test.databinding.UserCardBinding

class UserAdapter(private val onUserSelected: (User) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var userList: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UserCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(users: List<User>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }

    fun addMoreData(users: List<User>) {
        userList.addAll(users)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: UserCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = layoutPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedUser = userList[position]
                    onUserSelected.invoke(selectedUser)
                }
            }
        }

        fun bind(user: User) {
            Glide.with(itemView.context)
                .load(user.avatar)
                .into(binding.avatar)

            val fullName = "${user.firstName} ${user.lastName}"
            binding.fullName.text = fullName
            binding.email.text = user.email
        }
    }
}


