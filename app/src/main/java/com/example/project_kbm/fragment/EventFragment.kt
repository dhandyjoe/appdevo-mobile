package com.example.project_kbm.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_kbm.R
import com.example.project_kbm.activity.EventDetailActivity
import com.example.project_kbm.adapter.EventsAdapter
import com.example.project_kbm.adapter.NewsAdapter
import com.example.project_kbm.database.Constants.EVENT_DETAIL
import com.example.project_kbm.database.DataEvents
import com.example.project_kbm.databinding.ActivityEventDetailBinding
import com.example.project_kbm.databinding.FragmentEventBinding
import com.example.project_kbm.model.ModelEvent
import com.example.project_kbm.model.ModelNews

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentEventBinding
    private var eventList: ArrayList<ModelEvent>? = null
    private var searchList: ArrayList<ModelEvent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventBinding.inflate(inflater, container, false)
        eventList = DataEvents.getEventList()
        searchList = DataEvents.getEventList()

        binding.rvShimmerEvent.showShimmer()


        val handler = Handler()
        handler.postDelayed({
            binding.rvShimmerEvent.hideShimmer()
            binding.rvShimmerEvent.visibility = View.GONE
            binding.rvEvent.visibility = View.VISIBLE

        }, 2000)

        showRecycleView()
        searchEvent()

        return binding.root
    }

    private fun showRecycleView() {
        binding.rvEvent.layoutManager = GridLayoutManager(context, 2)
        val data = EventsAdapter(eventList!!, requireActivity())
        binding.rvEvent.adapter = data

        data.setOnClickListener(object : EventsAdapter.OnClickListener {
            override fun onClick(position: Int, model: ModelEvent) {
                val intent = Intent(activity, EventDetailActivity::class.java)
                intent.putExtra(EVENT_DETAIL, model)
                startActivity(intent)
            }
        })
    }

    private fun searchEvent() {
        binding.svEvent.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                eventList!!.clear()
                searchList!!.forEach {
                    if (it.name!!.toLowerCase().contains(query!!.toLowerCase())) {
                        eventList!!.add(it)
                        showRecycleView()
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                eventList!!.clear()
                searchList!!.forEach {
                    if (it.name!!.toLowerCase().contains(newText!!.toLowerCase())) {
                        eventList!!.add(it)
                        showRecycleView()
                    }
                }
                return false
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EventFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}