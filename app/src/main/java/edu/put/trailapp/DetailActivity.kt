package edu.put.trailapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.put.trailapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trailId = intent.getIntExtra("TRAIL_ID",-1)
        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag) as TrailDetailFragment
        frag.setTrailId(trailId)
    }

}
