package com.miu.student.mycv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.student.mycv.adapters.ViewPagerAdapter
import com.miu.student.mycv.databinding.ActivityMainBinding
import com.miu.student.mycv.fragments.Me

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,
            android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding!!.tabLayout.tabGravity = com.google.android.material.tabs.TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding!!.tabLayout, binding!!.viewPager) { tab, position ->
            //set text and icon for each tab
            tab.text = when (position) {
                0 -> "Me"
                1 -> "Experience"
                2 -> "Education"
                3 -> "Certification"
                else -> "Contact"
            }
            //set icon for each tab
            tab.setIcon(when (position) {
                0 -> R.drawable.me
                1 -> R.drawable.work
                2 -> R.drawable.school
                3 -> R.drawable.certification
                else -> R.drawable.contact
            })
        }.attach()
    }
}