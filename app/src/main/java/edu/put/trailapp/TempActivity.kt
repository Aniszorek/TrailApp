package edu.put.trailapp


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import edu.put.trailapp.fragments.StopperFragment


class TempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        enableEdgeToEdge()
        if (savedInstanceState == null) {
            val stoper = StopperFragment()
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.add(R.id.stopper_container, stoper)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        }
    }
}