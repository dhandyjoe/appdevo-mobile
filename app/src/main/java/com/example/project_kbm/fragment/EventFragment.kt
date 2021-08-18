package com.example.project_kbm.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project_kbm.activity.EventDetailActivity
import com.example.project_kbm.adapter.EventsAdapter
import com.example.project_kbm.adapter.NewsAdapter
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
    ): View? {
        binding = FragmentEventBinding.inflate(inflater, container, false)
        eventList = DataEvents.getEventList()

        showRecycleView()

        return binding.root
    }

    private fun showRecycleView() {
        binding.rvEvent.layoutManager = GridLayoutManager(context, 2)
        val data = EventsAdapter(eventList!!, requireActivity())
        binding.rvEvent.adapter = data

        data.setOnClickListener(object : EventsAdapter.OnClickListener {
            override fun onClick(position: Int, model: ModelEvent) {
                val intent = Intent(context, EventDetailActivity::class.java)
                startActivity(intent)
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