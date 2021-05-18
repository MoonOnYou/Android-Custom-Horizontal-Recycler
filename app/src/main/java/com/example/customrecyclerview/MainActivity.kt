package com.example.customrecyclerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFirstRecycler()
        setupSecondRecycler()
    }

    private fun setupFirstRecycler() {
        val adapter = Adapter(listOf("가", "나", "다", "라"))
        val recyclerView = findViewById<View>(R.id.recyclerView1) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.adapter = adapter

        // 한칸 씩 이동하게 설정
        val snapHelper: SnapHelper = PagerSnapHelper()
        if (recyclerView.onFlingListener == null) snapHelper.attachToRecyclerView(recyclerView)

    }

    private fun setupSecondRecycler(){
        val adapter = Adapter(listOf("가", "나", "다", "라"))
        val recyclerView = findViewById<View>(R.id.recyclerView2) as RecyclerView
        recyclerView.layoutManager = CenterZoomLayoutManager(this)
        recyclerView.adapter = adapter

        // 한칸 씩 이동하게 설정
        val snapHelper: SnapHelper = PagerSnapHelper()
        if (recyclerView.onFlingListener == null) snapHelper.attachToRecyclerView(recyclerView)
    }
}

