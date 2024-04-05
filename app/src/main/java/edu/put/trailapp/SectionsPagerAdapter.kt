package edu.put.trailapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return TopFragment()
            1 -> return TrailListFragment()
            2 -> return TrailListFragment()
        }
        return TopFragment()
    }
}