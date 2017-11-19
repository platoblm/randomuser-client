package com.example.randomuser.ui.users.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import javax.inject.Inject


class UserListAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder = null!! //TODO
    fun setItems(items: List<String>) {

    }
}