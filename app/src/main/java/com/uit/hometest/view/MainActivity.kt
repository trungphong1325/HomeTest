package com.uit.hometest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uit.hometest.R
import com.uit.hometest.model.KeyHotUIModel
import com.uit.hometest.utils.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mAdapter : KeyHotAdapter? = null

    private val listName : List<String> = listOf("bánh trung thu","xiaomi",
        "innisfree","balo","bitits hunter x","tai nghe", "anker","bánh trung thu kinh đô",
        "bitis","bts","banh trung thu", "son","tai nghe bluetooth", "bình giữ nhiệt", "harry potter", "túi đeo chéo",
        "đắc nhân tâm","laeige", "sạc dự phòng","anh chí là thành xuân của em")
    private val listColor : List<String> = listOf("#008000",
        "#003300",
        "#800000",
        "#003333",
        "#FF9966",
        "#000080",
        "#808000",
        "#00574B",
        "#008080",
        "#800080")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
    }

    private fun initializeView() {
        mAdapter = KeyHotAdapter()
        mAdapter?.submitList(hardCode())
        listKeyHot.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listKeyHot.addItemDecoration(SpacesItemDecoration(24))
        listKeyHot.adapter = mAdapter
    }

    private fun hardCode() : List<KeyHotUIModel>?{
        val list : MutableList<KeyHotUIModel> = mutableListOf()
        for(i in 0 until listName.size){
            val value = listName[i]
            list.add(KeyHotUIModel(value, listColor.random(), value.split(" ").size))
        }
        return list
    }

}
