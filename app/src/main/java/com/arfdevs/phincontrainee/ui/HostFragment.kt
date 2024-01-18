package com.arfdevs.phincontrainee.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.setupWithNavController
import com.arfdevs.phincontrainee.R
import com.arfdevs.phincontrainee.databinding.FragmentHostBinding

class HostFragment : Fragment() {

    private var _binding: FragmentHostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment

        val navView = binding.bottomNav
        val navController = findNavController(navHost)

        navView.setupWithNavController(navController)

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_notification -> {
                    true
                }

                R.id.menu_cart -> {
                    true
                }

                R.id.menu_reviews -> {
                    true
                }

                else -> false
            }
        }

    }
}