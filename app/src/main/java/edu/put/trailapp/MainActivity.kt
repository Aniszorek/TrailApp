package edu.put.trailapp

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import edu.put.trailapp.menu_activity.GalleryActivity
import edu.put.trailapp.menu_activity.ImportActivity


class MainActivity : AppCompatActivity(), TrailListFragment.Listener,
    TrailEasyListFragment.Listener, TrailHardListFragment.Listener, NavigationView.OnNavigationItemSelectedListener {

    private var shareActionProvider: ShareActionProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val pagerAdapter = SectionsPagerAdapter(supportFragmentManager, resources)
        val pager = findViewById<View>(R.id.pager) as ViewPager
        pager.setAdapter(pagerAdapter)

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(pager)

        val drawer = findViewById<View>(R.id.list_frag) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

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
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("TRAIL_ID", id)
            startActivity(intent)
        }

    }


    private class SectionsPagerAdapter(
        fm: FragmentManager?, private val resources: Resources
    ) : FragmentPagerAdapter(fm!!) {
        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return TrailListFragment()
                1 -> return TrailEasyListFragment()
                2 -> return TrailHardListFragment()
            }
            return TrailListFragment()
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return resources.getString(R.string.home_tab)
                1 -> return resources.getString(R.string.kat1_tab)
                2 -> return resources.getString(R.string.kat2_tab)
            }
            return null
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val intent: Intent = when (id) {
            R.id.drawer_import -> Intent(this, GalleryActivity::class.java)
            R.id.drawer_gallery -> Intent(this, ImportActivity::class.java)
            else -> Intent(this, MainActivity::class.java)
        }
        startActivity(intent)
        val drawer = findViewById<DrawerLayout>(R.id.list_frag)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun showMessage(msg: String) {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        toast.show()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.list_frag) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}

