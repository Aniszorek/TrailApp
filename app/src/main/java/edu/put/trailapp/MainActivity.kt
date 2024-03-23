package edu.put.trailapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), TrailListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun itemClicked(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("TRAIL_ID", id)
        startActivity(intent)
    }


}
