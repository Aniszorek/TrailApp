package edu.put.trailapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import edu.put.trailapp.model.Trail

class TrailDetailFragment : Fragment() {
    private var trailId: Int = 0

    fun setTrailId(id: Int) {
        this.trailId = id
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("trailId", trailId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            trailId = savedInstanceState.getInt("trailId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trail_detail, container, false)
    }

    override fun onStart() {
        super.onStart()

        val trail: Trail = Trail.getSampleTrails()[trailId]

        val name: TextView? = view?.findViewById(R.id.textTitle)
        name?.text = trail.name

        val description: TextView? = view?.findViewById(R.id.textDescription)
        description?.text = trail.description

        val stepList: ListView? = view?.findViewById(R.id.stages)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, trail.stages)
        stepList?.adapter = adapter
    }

}