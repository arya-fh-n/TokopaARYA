package com.arfdevs.phincontrainee.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arfdevs.phincontrainee.R
import com.arfdevs.phincontrainee.databinding.FragmentHomeBinding
import com.arfdevs.phincontrainee.ui.data.SharedPrefHelper

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var sharedPrefHelper: SharedPrefHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        sharedPrefHelper = SharedPrefHelper(requireContext())

        val darkModeEnabled = sharedPrefHelper.getValue(IS_DARK_MODE, false) as Boolean
        viewModel.setDarkMode(darkModeEnabled)
        updateTheme(darkModeEnabled)

        binding.apply {
            btnLogout.setOnClickListener {
                val mainNavController = requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container)
                    ?.findNavController()
                mainNavController?.navigate(R.id.action_hostFragment_to_loginFragment)
            }

            switchTheme.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    viewModel.setDarkMode(isChecked)
                    updateTheme(isChecked)
                    sharedPrefHelper.setValue(IS_DARK_MODE, isChecked)
                } else {
                    viewModel.setDarkMode(false)
                    updateTheme(false)
                    sharedPrefHelper.setValue(IS_DARK_MODE, false)
                }
            }

            viewModel.isDarkMode.observe(viewLifecycleOwner) {
                switchTheme.isChecked = it
            }
        }

    }

    private fun updateTheme(isDarkTheme: Boolean) {
        val theme = if (isDarkTheme) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }

        AppCompatDelegate.setDefaultNightMode(theme)
    }

    companion object {
        const val IS_DARK_MODE = "is_dark_mode"
    }

}