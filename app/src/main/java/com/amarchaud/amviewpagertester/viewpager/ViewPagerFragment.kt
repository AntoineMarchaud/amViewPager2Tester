package com.amarchaud.amviewpagertester.viewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.amarchaud.amviewpagertester.adapter.DemoCollectionAdapter
import com.amarchaud.amviewpagertester.data.viewmodel.PositionViewModel
import com.amarchaud.amviewpagertester.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    private lateinit var demoCollectionAdapter: DemoCollectionAdapter

    // listen by activity
    private val positionViewModel: PositionViewModel by activityViewModels()

    companion object {
        fun newInstance(): ViewPagerFragment {
            return ViewPagerFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater)
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("position", binding.viewPager.currentItem)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {

            demoCollectionAdapter = DemoCollectionAdapter(this@ViewPagerFragment)
            viewPager.adapter = demoCollectionAdapter
            savedInstanceState?.getInt("position")?.let {
                binding.viewPager.currentItem = it
            }

            // link tab to viewPager
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                // here you can add some options
                //tab.text = "OBJECT ${(position + 1)}"
            }.attach()


            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    //  Former method to send Fragment events
                    //listener.onPagerChangePage(position)

                    // modern method to send Fragment events
                    positionViewModel.setIndex(position)
                }
            })
        }
    }

    /*
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as IViewPagerChange
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement onViewSelected")
        }
    }*/
}