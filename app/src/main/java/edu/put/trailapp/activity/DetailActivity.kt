package edu.put.trailapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import edu.put.trailapp.R
import edu.put.trailapp.databinding.ActivityDetailBinding
import edu.put.trailapp.fragments.TrailDetailFragment
import edu.put.trailapp.model.Trail


class DetailActivity : AppCompatActivity() {
    private var shareActionProvider: ShareActionProvider? = null

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val trailId = intent.getIntExtra("TRAIL_ID",-1)
        val trail = Trail.getSampleTrails()[trailId]
        val textView: TextView = findViewById(R.id.trail_text)
        textView.text = trail.name

        val imageView: ImageView = findViewById(R.id.trail_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(this, trail.imageResourceId))
        imageView.contentDescription = trail.name

        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag) as TrailDetailFragment
        frag.setTrailId(trailId)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        println(menu)
        menuInflater.inflate(R.menu.menu_main, menu)

        val menuItem: MenuItem? = menu?.findItem(R.id.action_share)
        shareActionProvider =
            menuItem?.let { MenuItemCompat.getActionProvider(it) } as? ShareActionProvider
        setShareActionIntent("Blablablablablla")

        return super.onCreateOptionsMenu(menu)
    }

    private fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, text)
        this.shareActionProvider?.setShareIntent(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println(item.itemId)
        return when (item.itemId) {
            R.id.action_action -> {
                val intent = Intent(this, ActionActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onClickDone(view: View) {
        val context = view.context
        val toast = Toast.makeText(context, "Tu kiedyś będzie odpalany aparat", Toast.LENGTH_SHORT)
        toast.show()
    }

}
