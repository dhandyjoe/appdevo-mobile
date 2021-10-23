package com.example.project_kbm.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_kbm.R
import com.example.project_kbm.activity.CommitteeDetailActivity
import com.example.project_kbm.activity.EventDetailActivity
import com.example.project_kbm.adapter.CommitteeAdapter
import com.example.project_kbm.adapter.EventsAdapter
import com.example.project_kbm.database.Constants
import com.example.project_kbm.database.Constants.COMMITTEE_DETAIL
import com.example.project_kbm.database.DataCommittee
import com.example.project_kbm.databinding.FragmentCommitteeBinding
import com.example.project_kbm.model.ModelCommittee
import com.example.project_kbm.model.ModelEvent

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CommitteeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommitteeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentCommitteeBinding
    private var committeeList: ArrayList<ModelCommittee>? = null
    private var searchCommittee: ArrayList<ModelCommittee>? = null

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
        binding = FragmentCommitteeBinding.inflate(inflater, container, false)
        committeeList = DataCommittee.getCommitteeList()
        searchCommittee = DataCommittee.getCommitteeList()

        binding.rvShimmerCommittee.startShimmer()

        val handler = Handler()
        handler.postDelayed({
            binding.rvShimmerCommittee.stopShimmer()
            binding.rvShimmerCommittee.visibility = View.GONE
            binding.rvCommittee.visibility = View.VISIBLE
        }, 2000)

        showRecycleView()

        searchEvent()

        return binding.root
    }

    private fun showRecycleView() {
        binding.rvCommittee.layoutManager = LinearLayoutManager(activity)
        val data = CommitteeAdapter(committeeList!!, requireActivity())
        binding.rvCommittee.adapter = data

        data.setOnClickListener(object : CommitteeAdapter.OnClickListener {
            override fun onClick(position: Int, model: ModelCommittee) {
                val intent = Intent(activity, CommitteeDetailActivity::class.java)
                intent.putExtra(COMMITTEE_DETAIL, model)
                startActivity(intent)
            }
        })
    }

    private fun searchEvent() {
        binding.svCommittee.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                committeeList!!.clear()
                searchCommittee!!.forEach {
                    if (it.nameCommittee!!.toLowerCase().contains(query!!.toLowerCase())) {
                        committeeList!!.add(it)
                        showRecycleView()
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                committeeList!!.clear()
                searchCommittee!!.forEach {
                    if (it.nameCommittee!!.toLowerCase().contains(newText!!.toLowerCase())) {
                        committeeList!!.add(it)
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
         * @return A new instance of fragment CommitteeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommitteeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}