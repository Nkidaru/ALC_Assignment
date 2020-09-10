package com.example.alc_assignment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager2? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewpager)

        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        }

        button.setOnClickListener {
            startActivity(Intent(this, ProjectSubmissionActivity::class.java))

        }
        viewPager!!.adapter = MyAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout!!, viewPager!!) { tab, position ->
            when (position) {
                0 -> tab.text = "Learning Leaders"
                1 -> tab.text = "Skill IQ Leaders"

            }
        }.attach()
    }

    private class MyAdapter(fm: FragmentManager?, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm!!, lifecycle) {
        private val intItems = 2
        override fun createFragment(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = LearningLeadersFragment()
                1 -> fragment = SkillsIQFragment()
            }
            return fragment!!
        }

        override fun getItemCount(): Int {
            return intItems
        }

    }

}





