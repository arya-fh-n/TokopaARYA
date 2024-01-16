package com.arfdevs.phincontrainee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.arfdevs.phincontrainee.databinding.FragmentOnboardingBinding
import com.arfdevs.phincontrainee.databinding.FragmentSplashBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private val onboardingImages = listOf(
        R.drawable.ob_1,
        R.drawable.ob_2,
        R.drawable.ob_3
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(layoutInflater)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabs
        viewPager.adapter = OnboardingPagerAdapter(onboardingImages)

        TabLayoutMediator(tabLayout, viewPager) { tab, position -> }.attach()

        return binding.root
    }
}