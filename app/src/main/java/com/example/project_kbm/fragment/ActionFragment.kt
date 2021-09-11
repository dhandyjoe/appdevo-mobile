package com.example.project_kbm.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project_kbm.R
import com.example.project_kbm.activity.MainActivity
import com.example.project_kbm.activity.WebViewActionActivity
import com.example.project_kbm.databinding.FragmentActionBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentActionBinding


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
        val thisContext = container!!.context
        binding = FragmentActionBinding.inflate(inflater, container, false)


        binding.btnRequestTranskrip.setOnClickListener() {requestTranskrip()}
        binding.btnValidasiPembayaran.setOnClickListener() {validasiPembayaran()}
        binding.btnStars.setOnClickListener() {starsUKSW(thisContext)}
        binding.btnSiasat.setOnClickListener() {siasat(thisContext)}
        binding.btnRepo.setOnClickListener() {repoUKSW(thisContext)}
        binding.btnSita.setOnClickListener() {sita(thisContext)}

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun validasiPembayaran() {
        val recipient = arrayOf("bak@adm.uksw.edu")
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:");
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, recipient)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Validasi Bukti Bayar Tagihan Kuliah ");
        intent.putExtra(Intent.EXTRA_TEXT, "Selamat pagi, berikut saya lampirkan sebagai validasi dan bukti bayar tagihan semester kuliah\n" +
                "\n" +
                "Terimakasih\n" +
                "\n" +
                "NIM : 682018034");
        startActivity(Intent.createChooser(intent, "Choose"))
    }

    private fun requestTranskrip() {
        val recipient = arrayOf("baa.nilai@uksw.edu")
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:");
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, recipient)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Permintaan Cetak Transkrip Nilai ");
        startActivity(Intent.createChooser(intent, "Choose"))
    }

    private fun starsUKSW(thisContext: Context?) {
        val intent = Intent(thisContext, WebViewActionActivity::class.java)
        intent.putExtra("value", "https://stars.uksw.edu/")
        startActivity(intent)
    }

    private fun siasat(thisContext: Context?) {
        val intent = Intent(thisContext, WebViewActionActivity::class.java)
        intent.putExtra("value", "https://siasat.uksw.edu/")
        startActivity(intent)
    }

    private fun repoUKSW(thisContext: Context?) {
        val intent = Intent(thisContext, WebViewActionActivity::class.java)
        intent.putExtra("value", "https://repository.uksw.edu/")
        startActivity(intent)
    }

    private fun sita(thisContext: Context?) {
        val intent = Intent(thisContext, WebViewActionActivity::class.java)
        intent.putExtra("value", "http://online.fti.uksw.edu/")
        startActivity(intent)
    }
}