package com.amarchaud.amviewpagertester.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amarchaud.amviewpagertester.R
import com.amarchaud.amviewpagertester.databinding.FragmentViewPagerBinding
import com.amarchaud.amviewpagertester.databinding.FragmentViewPagerElementBinding


class ViewPagerElementFragment : Fragment() {

    private var _binding: FragmentViewPagerElementBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TITLE = "title"
        const val DESCRIPTION = "description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerElementBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            requireArguments().takeIf { it.containsKey(TITLE) }?.apply {
                title.text = getString(TITLE)
            }
            requireArguments().takeIf { it.containsKey(DESCRIPTION) }?.apply {
                description.text = getString(DESCRIPTION)
            }
        }

    }

}