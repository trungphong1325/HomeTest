package com.uit.hometest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uit.hometest.R
import com.uit.hometest.model.KeyHotUIModel
import com.uit.hometest.utils.SpacesItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mAdapter: KeyHotAdapter? = null

    private val listName: List<String> = listOf(
        "bánh trung thu", "xiaomi",
        "innisfree", "balo", "bitits hunter x", "tai nghe", "anker", "bánh trung thu kinh đô",
        "bitis", "bts", "banh trung thu", "son", "tai nghe bluetooth", "bình giữ nhiệt", "harry potter", "túi đeo chéo",
        "đắc nhân tâm", "laeige", "sạc dự phòng", "anh chí là thanh xuân của em"
    )
    private val listColor: List<String> = listOf(
        "#008000",
        "#003300",
        "#800000",
        "#003333",
        "#FF9966",
        "#000080",
        "#808000",
        "#00574B",
        "#008080",
        "#800080"
    )

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

    private fun hardCode(): List<KeyHotUIModel>? {
        val list: MutableList<KeyHotUIModel> = mutableListOf()
        for (i in 0 until listName.size) {
            val name = listName[i].trim()
            val listValue = name.split(" ")
            var wrapLineName = ""
            if(listValue.size>1){
                listValue.forEachIndexed { index, char ->
                    val keyWord = if (index == listValue.size / 2) {
                      WRAP_LINE + char
                    }else{
                        char
                    }
                    wrapLineName += "$keyWord "
                }
            }else{
                wrapLineName = name
            }

            list.add(KeyHotUIModel(wrapLineName, listColor.random()))
        }
        return list
    }

    companion object {
        private const val WRAP_LINE = "\n"
    }

}
