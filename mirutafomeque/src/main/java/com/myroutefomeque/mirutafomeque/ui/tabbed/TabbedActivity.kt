package com.myroutefomeque.mirutafomeque.ui.tabbed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myroutefomeque.mirutafomeque.databinding.ActivityTabbedBinding

class TabbedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabbedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabbedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)


    }
}