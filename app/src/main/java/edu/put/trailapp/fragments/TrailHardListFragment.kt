package edu.put.trailapp.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.put.trailapp.CaptionedImagesAdapter
import edu.put.trailapp.activity.DetailActivity
import edu.put.trailapp.R
import edu.put.trailapp.model.Trail

class TrailHardListFragment : Fragment() {

    interface Listener {
        fun itemClicked(id: Int)
    }

    private var listener: Listener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val trailRecycler =
            inflater.inflate(R.layout.fragment_trail_hard_list, container, false) as RecyclerView

        val trailsList = Trail.getSampleTrails()
        val easyTrails = trailsList.filter { it.difficulty == "hard" }
        val trailsNames = easyTrails.map { it.name }

        val trailsImages = easyTrails.map { it.imageResourceId }

        val adapter = CaptionedImagesAdapter(trailsNames.toTypedArray(), trailsImages.toIntArray())
        trailRecycler.setAdapter(adapter)

        val layoutManager = GridLayoutManager(activity, 2)
        trailRecycler.setLayoutManager(layoutManager)

        adapter.setListener(object : CaptionedImagesAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(requireActivity(), DetailActivity::class.java)
                intent.putExtra("TRAIL_ID", position)
                requireActivity().startActivity(intent)
            }
        })

        return trailRecycler
    }

}