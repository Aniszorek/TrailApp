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
            0 -> return TrailListFragment()
            1 -> return TrailEasyListFragment()
            2 -> return TrailHardListFragment()
        }
        return TopFragment()
    }
}