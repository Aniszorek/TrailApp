package edu.put.trailapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity(), TrailListFragment.Listener {

    private var shareActionProvider: ShareActionProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        println(menu)
        menuInflater.inflate(R.menu.menu_main, menu);

        val menuItem: MenuItem? = menu?.findItem(R.id.action_share)
        shareActionProvider = menuItem?.let { MenuItemCompat.getActionProvider(it) } as? ShareActionProvider
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
