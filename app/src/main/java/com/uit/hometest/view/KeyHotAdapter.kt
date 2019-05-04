package com.uit.hometest.view

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.uit.hometest.R
import com.uit.hometest.model.KeyHotUIModel
import com.uit.hometest.model.UIModel
import com.uit.hometest.utils.NoteDiffCallBack
import kotlinx.android.synthetic.main.item_key_hot.view.*
import java.util.ArrayList
import java.util.concurrent.Executors
import android.graphics.drawable.GradientDrawable
import com.uit.hometest.extentions.inflate

class KeyHotAdapter : ListAdapter<UIModel, KeyHotAdapter.ViewHolder>(
    AsyncDifferConfig.Builder<UIModel>(NoteDiffCallBack())
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    private var drawable: GradientDrawable? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = parent.inflate(R.layout.item_key_hot)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position) as? KeyHotUIModel
        if(drawable==null){
            drawable = holder.txtName.background as? GradientDrawable
        }
        holder.txtName.text = model?.name
        drawable?.setColor(Color.parseColor(model?.background))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName = view.name!!
    }

    override fun submitList(list: List<UIModel>?) {
        super.submitList(ArrayList<UIModel>(list ?: listOf()))
    }
}