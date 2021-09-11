package com.example.project_kbm.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_kbm.R
import com.example.project_kbm.activity.EventDetailActivity
import com.example.project_kbm.activity.LoginActivity
import com.example.project_kbm.activity.NewsDetailActivity
import com.example.project_kbm.adapter.NewsAdapter
import com.example.project_kbm.database.Constants.NEWS_DETAIL
import com.example.project_kbm.database.DataNews
import com.example.project_kbm.databinding.FragmentNewsBinding
import com.example.project_kbm.model.ModelNews
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentNewsBinding
    private lateinit var thisContext: Context
    private var newsList : ArrayList<ModelNews>? = null
    private var displayLst: ArrayList<ModelNews>? = null
    private lateinit var newText: String

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
        thisContext = container!!.context
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        displayLst = DataNews.getNewsList()
        newsList = DataNews.getNewsList()
        binding.rvShimmerNews.startShimmer()

        val handler = Handler()
        handler.postDelayed({
            binding.rvShimmerNews.stopShimmer()
            binding.rvShimmerNews.visibility = View.GONE
            binding.rvNews.visibility = View.VISIBLE
        }, 2000)


        showRecycleView()

        spinnerNews()



        return binding.root
    }

    private fun showRecycleView() {
        binding.rvNews.layoutManager = LinearLayoutManager(activity)
        val data = NewsAdapter(newsList!!)
        binding.rvNews.adapter = data

        data.setOnClickListener(object : NewsAdapter.OnClickListener {
            override fun onClick(position: Int, model: ModelNews) {
                val intent = Intent(activity, NewsDetailActivity::class.java)
                intent.putExtra(NEWS_DETAIL, model)
                startActivity(intent)
            }
        })
    }

    private fun spinnerNews() {
        val list = resources.getStringArray(R.array.spiiner_news)
        val adapter = ArrayAdapter(thisContext, android.R.layout.simple_spinner_item, list)
        binding.spNews.adapter = adapter

        binding.spNews.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    newsList!!.clear()

                    displayLst!!.forEach {
                        if (it.nameCategory.contains(list[position])){
                            newsList!!.add(it)
                            showRecycleView()

                        }
                    }
                } else if (position == 2) {
                    newsList!!.clear()

                    displayLst!!.forEach {
                        if (it.nameCategory.contains(list[position])){
                            newsList!!.add(it)
                            showRecycleView()

                        }
                    }
                } else if (position == 3) {
                    newsList!!.clear()

                    displayLst!!.forEach {
                        if (it.nameCategory.contains(list[position])){
                            newsList!!.add(it)
                            showRecycleView()

                        }
                    }
                } else {
                    newsList = DataNews.getNewsList()
                    showRecycleView()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}