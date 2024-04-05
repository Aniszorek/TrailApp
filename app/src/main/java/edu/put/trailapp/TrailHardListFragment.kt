package edu.put.trailapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import edu.put.trailapp.model.Trail

class TrailHardListFragment : ListFragment() {

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
        // Inflate the layout for this fragment
        val trailsList = Trail.getSampleTrails()
        val easyTrails = trailsList.filter { it.difficulty == "hard" }
        val trailsNames = easyTrails.map { it.name }

        val adapter: ArrayAdapter<String?> =
            ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, trailsNames)
        setListAdapter(adapter)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        listener?.itemClicked(position)
    }
}