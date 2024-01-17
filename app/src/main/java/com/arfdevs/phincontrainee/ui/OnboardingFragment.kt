package com.arfdevs.phincontrainee.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.arfdevs.phincontrainee.R
import com.arfdevs.phincontrainee.databinding.FragmentOnboardingBinding
import com.arfdevs.phincontrainee.ui.adapter.OnboardingPagerAdapter
import com.arfdevs.phincontrainee.ui.data.SharedPrefHelper
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: OnboardingViewModel

    private lateinit var sharedPref: SharedPrefHelper

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

        sharedPref = SharedPrefHelper(requireContext())

        viewModel = ViewModelProvider(this).get(OnboardingViewModel::class.java)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabs
        viewPager.adapter = OnboardingPagerAdapter(onboardingImages)

        TabLayoutMediator(tabLayout, viewPager) { tab, position -> }.attach()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref.setValue(SplashFragment.IS_ONBOARDING_SHOWN, true)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.setIndex(position)
                if (position == 2) {
                    binding.btnObSelanjutnya.visibility = View.INVISIBLE
                } else
                    binding.btnObSelanjutnya.visibility = View.VISIBLE
            }
        })

        viewModel.index.observe(viewLifecycleOwner) { index ->
            binding.btnObSelanjutnya.setOnClickListener {
                binding.viewPager.currentItem += 1
            }
        }

        binding.btnObGabung.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegisterFragment())
                .commit()
        }

        binding.btnObLewati.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
        }

    }
}