package com.miu.student.mycv

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.get
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.student.mycv.adapters.ViewPagerAdapter
import com.miu.student.mycv.databinding.ActivityMainBinding
import com.miu.student.mycv.fragments.Me
import com.miu.student.mycv.infrastucture.MyCVPopupMenu

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("RestrictedApi")
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
            tab.setIcon(
                when (position) {
                    0 -> R.drawable.me
                    1 -> R.drawable.work
                    2 -> R.drawable.school
                    3 -> R.drawable.certification
                    else -> R.drawable.contact
                }
            )
        }.attach()

        binding.contactMe.setOnClickListener {

            var popupMenu = PopupMenu(this, binding.contactMe)
            popupMenu.menuInflater.inflate(R.menu.contact_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.whatsApp -> {
                        var intent = android.content.Intent(android.content.Intent.ACTION_VIEW)
                        intent.data = android.net.Uri.parse("https://wa.me/13196770270")
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.facebook -> {
                        var intent = android.content.Intent(android.content.Intent.ACTION_VIEW)
                        intent.data = android.net.Uri.parse("https://m.facebook.com/aroi2imaa")
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.instagram -> {
                        var intent = android.content.Intent(android.content.Intent.ACTION_VIEW)
                        intent.data = android.net.Uri.parse("https://m.instagram.com/ibrahimabulubbad")
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    R.id.twitter -> {
                        var intent = android.content.Intent(android.content.Intent.ACTION_VIEW)
                        intent.data = android.net.Uri.parse("https://twitter.com/IbrahimAbulubad")
                        startActivity(intent)
                        return@setOnMenuItemClickListener true
                    }
                    else -> {
                        var toast = android.widget.Toast.makeText(
                            this,
                            "Email",
                            android.widget.Toast.LENGTH_SHORT
                        )
                        toast.show()
                        return@setOnMenuItemClickListener true
                    }
                }

            }
            var popup = MenuPopupHelper(this, popupMenu.menu as androidx.appcompat.view.menu.MenuBuilder, binding.contactMe)
            popup.setForceShowIcon(true)
            popup.gravity = android.view.Gravity.END
            popup.show()
        }
    }
}