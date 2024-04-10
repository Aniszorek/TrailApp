package edu.put.trailapp.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.put.trailapp.R


class StopperFragment : Fragment(), View.OnClickListener {

    interface StopperListener {
        fun onTimeStopped(time: String)
    }

    private var listener: StopperListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is StopperListener) {
            context
        } else {
            throw RuntimeException("$context must implement StopperListener")
        }
    }

    var seconds: Int = 0
    var running: Boolean = false
    var wasRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layout: View = inflater.inflate(R.layout.fragment_stopper, container, false)
        runStoper(layout)
        val startButton = layout.findViewById<View>(R.id.start_button) as Button
        startButton.setOnClickListener(this)
        val stopButton = layout.findViewById<View>(R.id.stop_button) as Button
        stopButton.setOnClickListener(this)
        val resetButton = layout.findViewById<View>(R.id.reset_button) as Button
        resetButton.setOnClickListener(this)
        return layout
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
        }
    }


    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("warRunning", wasRunning)
    }

    private fun onClickStart() {
        running = true
    }

    private fun onClickStop() {
        running = false
        listener?.onTimeStopped(getFormattedTime())
    }

    private fun onClickReset() {
        running = false
        seconds = 0
    }

    private fun runStoper(view: View) {
        val timeView: TextView = view.findViewById(R.id.time_view)
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours: Int = seconds / 3600
                val minutes: Int = (seconds % 3600) / 60
                val secs: Int = seconds % 60
                val time: String = String.format("%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun getFormattedTime(): String {
        val hours: Int = seconds / 3600
        val minutes: Int = (seconds % 3600) / 60
        val secs: Int = seconds % 60
        return String.format("%d:%02d:%02d", hours, minutes, secs)
    }

    fun setStopperListener(listener: StopperListener) {
        this.listener = listener
    }
}

