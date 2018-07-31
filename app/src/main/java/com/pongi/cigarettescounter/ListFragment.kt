package com.pongi.cigarettescounter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pongi.cigarettescounter.entity.SmokingLog
import com.pongi.cigarettescounter.viewmodel.MainViewModel

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ListFragment.OnListFragmentInteractionListener] interface.
 */
class ListFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_list, container, false)

        activity?.let { activity ->
            val viewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
            viewModel.smokingLog.observe(this, Observer {
                it?.let {
                    // Set the adapter
                    if (view is RecyclerView) {
                        with(view) {

                            val array = ArrayList<SmokingLog>()
                            for ( i in 1..59) {
                                array.add(SmokingLog("2018/08/01 10:00:0${i}", count = 1))
                            }

                            layoutManager = LinearLayoutManager(context)
                            adapter = MyListRecyclerViewAdapter(array, listener)

                        }
                    }
                }
            });
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: SmokingLog?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                ListFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
