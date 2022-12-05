package com.miu.student.mycv.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.student.mycv.fragments.*

class ViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount() =5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Me()
            1 -> Experience()
            2 -> Education ()
            3 -> Certification()
            4 -> Contact()
            else -> Me()
        }
    }


}