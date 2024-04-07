package edu.put.trailapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.put.trailapp.R


class TrailListFragment : Fragment() {

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
//        val trailsList = Trail.getSampleTrails()
//        val trailsNames = trailsList.map { it.name }
//
//        val adapter: ArrayAdapter<String?> =
//            ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, trailsNames)
//        setListAdapter(adapter)


        return inflater.inflate(R.layout.fragment_trail_list, container, false)
    }


}