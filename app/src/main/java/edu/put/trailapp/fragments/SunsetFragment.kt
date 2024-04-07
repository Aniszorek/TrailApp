package edu.put.trailapp.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.fragment.app.Fragment
import edu.put.trailapp.R
import edu.put.trailapp.activity.MainActivity


class SunsetFragment : Fragment() {

    private var mSceneView: View? = null
    private var mSunView: View? = null
    private var mSkyView: View? = null
    private var mBlueSkyColor = 0
    private var mSunsetSkyColor = 0
    private var mNightSkyColor = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sunset, container, false)
        mSceneView = view
        mSunView = view.findViewById<View>(R.id.sun)
        mSkyView = view.findViewById<View>(R.id.sky)

        val resources = resources
        mBlueSkyColor = resources.getColor(R.color.blue_sky)
        mSunsetSkyColor = resources.getColor(R.color.sunset_sky)
        mNightSkyColor = resources.getColor(R.color.night_sky)

        mSceneView!!.setOnClickListener { startAnimation() }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startAnimation()
    }


    private fun startAnimation() {
        mSkyView?.post {
            val skyHeight = mSkyView?.height ?: 0
            val sunYStart = skyHeight.toFloat()
            val sunYEnd = skyHeight / 2.toFloat()

            val heightAnimator = ObjectAnimator.ofFloat(mSunView!!, "y", sunYStart, sunYEnd)
                .setDuration(3000)
            heightAnimator.interpolator = AccelerateInterpolator()

            val sunriseSkyAnimator =
                ObjectAnimator.ofArgb(mSkyView!!, "backgroundColor", mSunsetSkyColor, mBlueSkyColor)
                    .setDuration(3000)

            val animatorSet = AnimatorSet()
            animatorSet
                .play(heightAnimator)
                .with(sunriseSkyAnimator)

            animatorSet.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                }
            })

            animatorSet.start()
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return SunsetFragment()
        }
    }


}