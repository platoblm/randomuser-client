package com.example.randomuser.ui.users.list.recyclerview

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.example.randomuser.R
import com.example.randomuser.base.helpers.inflateWithoutAttaching
import com.example.randomuser.base.helpers.onClick
import com.example.randomuser.base.images.ImageLoader
import com.example.randomuser.ui.users.list.UserListItem
import kotlinx.android.synthetic.main.item_user_list.view.*

class UserListItemViewHolder(parent: ViewGroup,
                             private val imageLoader: ImageLoader)
    : ViewHolder(parent.inflateWithoutAttaching(R.layout.item_user_list)) {

    fun update(item: UserListItem) = item.updateView()

    private fun UserListItem.updateView() {
        imageLoader.loadInto(imageUrl, itemView.photo_view)
        itemView.title_view.text = title
        itemView.onClick(whenSelected::invoke)
    }
}