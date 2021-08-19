package com.example.project_kbm.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_kbm.activity.EventDetailActivity
import com.example.project_kbm.activity.LoginActivity
import com.example.project_kbm.activity.NewsDetailActivity
import com.example.project_kbm.adapter.NewsAdapter
import com.example.project_kbm.database.DataNews
import com.example.project_kbm.databinding.FragmentNewsBinding
import com.example.project_kbm.model.ModelNews

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
    private var newsList : ArrayList<ModelNews>? = null

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
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        newsList = DataNews.getNewsList()
        binding.rvShimmerNews.startShimmer()

        val handler = Handler()
        handler.postDelayed({
            binding.rvShimmerNews.stopShimmer()
            binding.rvShimmerNews.visibility = View.GONE
            binding.rvNews.visibility = View.VISIBLE
        }, 3000)

        showRecycleView()

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

    companion object {
        val NEWS_DETAIL = "news_detail"
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