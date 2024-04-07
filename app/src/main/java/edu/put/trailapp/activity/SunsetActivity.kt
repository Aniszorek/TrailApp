package edu.put.trailapp.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import edu.put.trailapp.R
import edu.put.trailapp.SingleFragmentActivity
import edu.put.trailapp.fragments.SunsetFragment

class SunsetActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return SunsetFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sunset)
    }
}