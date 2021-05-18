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
        setupThirdRecycler()
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
        // 커스텀 레이아웃 매니저 사용 1 ( 가운데 애니매이션 효과 )
        recyclerView.layoutManager = CenterZoomLayoutManager(this)
        recyclerView.adapter = adapter

        // 한칸 씩 이동하게 설정
        val snapHelper: SnapHelper = PagerSnapHelper()
        if (recyclerView.onFlingListener == null) snapHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupThirdRecycler() {
        val adapter = Adapter(listOf("가", "나", "다", "라"))
        val recyclerView = findViewById<View>(R.id.recyclerView3) as RecyclerView
        // 커스텀 레이아웃 매니저 사용 2 ( 한개 반씩 보여줌 )
        recyclerView.layoutManager = PeekingLinearLayoutManager(this)
        recyclerView.adapter = adapter

        // 한칸 씩 이동하게 설정
        val snapHelper: SnapHelper = PagerSnapHelper()
        if (recyclerView.onFlingListener == null) snapHelper.attachToRecyclerView(recyclerView)
    }
}

