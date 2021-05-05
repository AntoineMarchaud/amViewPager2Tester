package com.amarchaud.amviewpagertester

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.amarchaud.amviewpagertester.data.viewmodel.PositionViewModel
import com.amarchaud.amviewpagertester.databinding.ActivityMainBinding
import com.amarchaud.amviewpagertester.viewpager.ViewPagerFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val positionViewModel: PositionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .add(R.id.viewPagerContainer, ViewPagerFragment.newInstance())
            .commit()

        /**
         * Modern method to listener Fragment callback
         */
        positionViewModel.index.observe(this, { index ->
            changeTopImage(index)
        })
    }


    private fun changeTopImage(index: Int) {
        binding.run {
            when (index) {
                0 -> {
                    imageTop.setImageResource(R.drawable.ic_launcher_background)
                }
                1 -> {
                    imageTop.setImageResource(R.drawable.ic_launcher_foreground)
                }
                2 -> {
                    imageTop.setImageResource(R.drawable.default_dot)
                }
            }
        }
    }
}