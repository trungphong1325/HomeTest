package com.uit.hometest.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.uit.hometest.model.UIModel

class NoteDiffCallBack : DiffUtil.ItemCallback<UIModel>(){
    override fun areItemsTheSame(oldItem: UIModel, newItem: UIModel): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: UIModel, newItem: UIModel): Boolean {
        return oldItem == newItem
    }

}