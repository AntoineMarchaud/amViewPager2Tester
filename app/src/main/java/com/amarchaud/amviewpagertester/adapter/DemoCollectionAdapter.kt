package com.amarchaud.amviewpagertester.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.amarchaud.amviewpagertester.viewpager.ViewPagerElementFragment


class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = ViewPagerElementFragment()
        when (position) {
            0 -> {
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putString(ViewPagerElementFragment.TITLE, "titre 1")
                    putString(ViewPagerElementFragment.DESCRIPTION, "desc 1")
                }
            }
            1 -> {
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putString(ViewPagerElementFragment.TITLE, "titre 2")
                    putString(ViewPagerElementFragment.DESCRIPTION, "desc 2")
                }
            }
            2 -> {
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putString(ViewPagerElementFragment.TITLE, "titre 3")
                    putString(ViewPagerElementFragment.DESCRIPTION, "desc 3")
                }
            }
        }

        return fragment
    }
}