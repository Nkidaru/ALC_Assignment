package com.example.alc_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewpager)
        viewPager!!.adapter = MyAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout!!, viewPager!!) { tab, position ->
            when (position) {
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"

            }
        }.attach()
    }

    private inner class MyAdapter(fm: FragmentManager?, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm!!, lifecycle) {
        private val intItems = 2
        override fun createFragment(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = Leaders()
                1 -> fragment = SkillsIQ()
            }
            return fragment!!
        }

        override fun getItemCount(): Int {
            return intItems
        }
    }

}





