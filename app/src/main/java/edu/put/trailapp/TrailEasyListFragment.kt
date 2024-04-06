package edu.put.trailapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.put.trailapp.model.Trail


class TrailEasyListFragment : Fragment() {

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
    ): View? {
        val trailRecycler =
            inflater.inflate(R.layout.fragment_trail_easy_list, container, false) as RecyclerView

        val trailsList = Trail.getSampleTrails()
        val easyTrails = trailsList.filter { it.difficulty == "easy" }
        val trailsNames = easyTrails.map { it.name }

        val trailsImages = easyTrails.map { it.imageResourceId }

        val adapter = CaptionedImagesAdapter(trailsNames.toTypedArray(), trailsImages.toIntArray())
        trailRecycler.setAdapter(adapter)

        val layoutManager = GridLayoutManager(activity, 2)
        trailRecycler.setLayoutManager(layoutManager)

        return trailRecycler


        //        // Inflate the layout for this fragment
//        val trailsList = Trail.getSampleTrails()
//        val easyTrails = trailsList.filter { it.difficulty == "easy" }
//        val trailsNames = easyTrails.map { it.name }
//
//        val adapter: ArrayAdapter<String?> =
//            ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, trailsNames)
//        setListAdapter(adapter)
//
//        return super.onCreateView(inflater, container, savedInstanceState)
    }


}