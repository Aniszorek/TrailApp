package edu.put.trailapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(), TrailListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun itemClicked(id: Int) {
        val fragmentContainer: View? = findViewById(R.id.fragment_container)
        if (fragmentContainer != null) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            val details = TrailDetailFragment()
            details.setTrailId(id)
            ft.replace(R.id.fragment_container, details)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.addToBackStack(null)
            ft.commit()
        }
        else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("TRAIL_ID", id)
            startActivity(intent)
        }

    }


}
