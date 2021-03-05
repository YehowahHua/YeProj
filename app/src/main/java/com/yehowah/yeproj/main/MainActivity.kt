package com.yehowah.yeproj.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yehowah.yeproj.common.ui.component.HiBaseActivity
import com.yehowah.yeproj.main.logic.MainActivityLogic

class MainActivity : HiBaseActivity(), MainActivityLogic.ActivityProvider {


    private lateinit var mainActivityLogic: MainActivityLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityLogic = MainActivityLogic(this)




    }




}