package com.arfdevs.phincontrainee.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.arfdevs.phincontrainee.R
import com.arfdevs.phincontrainee.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            Glide.with(requireContext())
                .load(R.drawable.profile_placeholder)
                .centerCrop()
                .circleCrop()
                .into(ivUserPhoto)

            ivUserPhoto.setOnClickListener {
                showImagePickDialog()
            }
        }


    }

    private fun showImagePickDialog() {
        val dialogTitle = "Pilih Gambar"

        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        alertDialogBuilder.setTitle(dialogTitle)
        alertDialogBuilder
            .setPositiveButton("Kamera") { _, _ ->
                Toast.makeText(
                    requireActivity(),
                    "Gambar dipilih dari kamera",
                    Toast.LENGTH_SHORT
                ) //camera
                    .show()
            }
            .setNegativeButton("Galeri") { _, _ ->
                Toast.makeText(
                    requireActivity(),
                    "Gambar dipilih dari kamera",
                    Toast.LENGTH_SHORT
                ) //image pick
                    .show()
            }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

//    private val launcherIntentCamera = registerForActivityResult(
//        ActivityResultContracts.TakePicture()
//    ) { success ->
//        if (success) {
//
//        }
//    }

//    private val launcherGallery = registerForActivityResult(
//        ActivityResultContracts.PickVisualMedia()
//    ) { uri: Uri? ->
//        if (uri != null) {
//            imageUri = uri
//            showImage()
//        } else {
//            Log.d("Photo Picker", "No media selected")
//        }
//    }

//    private fun showImage() {
//        imageUri?.let {
//            binding.ivUserPhoto.setImageURI(it)
//        }
//    }
}