package com.example.project_kbm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.project_kbm.R
import com.example.project_kbm.databinding.ActivityMainBinding
import com.example.project_kbm.fragment.*
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttomNavigation.setItemSelected(R.id.menuNews, true)

        setupFragment(NewsFragment())

        // Replace Fragment
        binding.buttomNavigation.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener{
            override fun onItemSelected(id: Int) {
                when(id) {
                    R.id.menuNews -> setupFragment(NewsFragment())
                    R.id.menuEvents -> setupFragment(EventFragment())
                    R.id.menuCommittee -> setupFragment(CommitteeFragment())
                    R.id.menuAction -> setupFragment(ActionFragment())
                    R.id.menuSetting -> setupFragment(SettingFragment())
                }
            }
        })
    }

    private fun setupFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.commit()
    }
}