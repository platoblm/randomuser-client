package com.example.randomuser.ui.users.list.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.randomuser.base.images.ImageLoader
import com.example.randomuser.ui.users.list.UserListItem
import javax.inject.Inject


class UserListAdapter @Inject constructor(private val imageLoader: ImageLoader) : RecyclerView.Adapter<UserListItemViewHolder>() {

    private var items = emptyList<UserListItem>()

    fun setItems(items: List<UserListItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) = holder.update(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserListItemViewHolder(parent, imageLoader)
}