package com.wonkbike.utils


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wonkbike.ui.landing.LandingFragment

class ViewPagerAdapter(
    fa: FragmentActivity ,
    listener: (CharSequence) -> Unit
) :
    FragmentStateAdapter(fa) {
    private val dataFragments = mutableListOf(
        LandingFragment.newInstance(
            "Player VS Player." ,
            "1" ,
            listener
        ) ,
        LandingFragment.newInstance(
            "Player VS Computer." ,
            "2" ,
            listener
        ) ,
        LandingFragment.newInstance("Create Your Name" , "3" , listener)
    )

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        dataFragments[position]
}