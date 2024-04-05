package edu.put.trailapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import edu.put.trailapp.model.Trail


class TrailListFragment : ListFragment() {

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
        val trailsNames = trailsList.map { it.name }

        val adapter2: ArrayAdapter<Any?> = ArrayAdapter<Any?>(
            inflater.context,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.kategoria1)
        )
        setListAdapter(adapter2)

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