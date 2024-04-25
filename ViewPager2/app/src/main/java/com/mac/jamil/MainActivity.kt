package com.mac.jamil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.mac.jamil.adapters.FragmentPagesAdapter
import com.mac.jamil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding:ActivityMainBinding
    private lateinit var adapter:FragmentPagesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportActionBar?.title = "Dashboard"

        adapter = FragmentPagesAdapter(supportFragmentManager, lifecycle)

        mBinding.tabLayout.addTab(mBinding.tabLayout.newTab().setText("Home"))
        mBinding.tabLayout.addTab(mBinding.tabLayout.newTab().setText("About"))

        mBinding.viewPager.adapter = adapter

        mBinding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    mBinding.viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        mBinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mBinding.tabLayout.selectTab(mBinding.tabLayout.getTabAt(position))
            }
        })

    }
}