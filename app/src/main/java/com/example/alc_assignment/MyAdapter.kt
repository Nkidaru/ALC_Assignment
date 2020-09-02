package com.example.alc_assignment
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.viewpager2.adapter.FragmentStateAdapter
//
//class MyAdapter(fm: FragmentManager, internal var totalTabs: Int) :
//    FragmentStateAdapter(fm){
//
//    // this is for fragment tabs
//
//    override fun getItemCount(): Int {
//       return  totalTabs
//    }
//
//    override fun createFragment(position: Int): Fragment {
//
//        return when (position){
//
//            0 -> {
//
//                LeaderBoard()
//            }
//            1 -> {
//                SkillsIQ()
//            }
//
//            else -> LeaderBoard()
//
//        }
//
//    }
//}