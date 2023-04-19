package com.example.utspraktikum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import java.util.ArrayList

import com.example.utspraktikum.ItemAdapter.Companion.SPAN_COUNT_ONE
import com.example.utspraktikum.ItemAdapter.Companion.SPAN_COUNT_TWO

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        initItemsData()

        gridLayoutManager = GridLayoutManager(this, SPAN_COUNT_ONE)
        itemAdapter = ItemAdapter(items, gridLayoutManager)
        recyclerView = findViewById(R.id.rvData)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = gridLayoutManager
    }

    private fun initItemsData() {
        items = ArrayList<Item>(9).apply {
            add(Item(R.drawable.hyojung, "Choi Hyo Jung", "152100400028", 29))
            add(Item(R.drawable.choi_seung_cheol, "Choi Seung Cheol", "152500500008", 28))
            add(Item(R.drawable.jeonghan, "Yoon Jeong Han", "152500500004", 28))
            add(Item(R.drawable.joshua, "Joshua Hong", "152500500030", 28))
            add(Item(R.drawable.mimi, "Kim Mi Hyun", "152100400001", 28))
            add(Item(R.drawable.yooa, "Yoo Shi Ah", "152100400017", 28))
            add(Item(R.drawable.jun, "Wen Jun Hui", "152500500010", 27))
            add(Item(R.drawable.hoshi, "Kwon Soon Young", "152500500015", 27))
            add(Item(R.drawable.wonwoo, "Jeon Won Woo", "152500500017", 27))
            add(Item(R.drawable.woozi, "Lee Ji Hoon", "152500500022", 27))
            add(Item(R.drawable.seunghee, "Hyun Seung Hee", "152100400025", 27))
            add(Item(R.drawable.dk, "Lee Seok Min", "152500500018", 26))
            add(Item(R.drawable.mingyu, "Kim Min Gyu", "152500500006", 26))
            add(Item(R.drawable.the8, "Xu Ming Hao", "152500500010", 26))
            add(Item(R.drawable.binnie, "Bae Yu Bin", "152100400009", 26))
            add(Item(R.drawable.jiho, "Kim Ji Ho", "152100400004", 26))
            add(Item(R.drawable.seungkwan, "Boo Seung Kwan", "152500500016", 25))
            add(Item(R.drawable.vernon, "Choi Han Sol", "152500500218", 25))
            add(Item(R.drawable.dino, "Lee Chan", "152500500011", 24))
            add(Item(R.drawable.arin, "Choi Ye Won", "152100400018", 24))
            add(Item(R.drawable.karina, "Yu Ji Min", "201701100024", 23))
            add(Item(R.drawable.giselle, "Uchinaga Aeri", "201701100022", 23))
            add(Item(R.drawable.winter, "Kim Min Jeong", "201701100044", 22))
            add(Item(R.drawable.ningning, "Ning Yi Zhou", "201701100094", 21))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_switch) {
            switchLayout()
            switchIcon(item)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun switchLayout() {
        if (gridLayoutManager.spanCount == SPAN_COUNT_ONE) {
            gridLayoutManager.spanCount = SPAN_COUNT_TWO
        } else {
            gridLayoutManager.spanCount = SPAN_COUNT_ONE
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.itemCount)
    }

    private fun switchIcon(item: MenuItem) {
        if (gridLayoutManager.spanCount == SPAN_COUNT_TWO) {
            item.setIcon(resources.getDrawable(R.drawable.va_grid))
        } else {
            item.setIcon(resources.getDrawable(R.drawable.va_menu))
        }
    }
}