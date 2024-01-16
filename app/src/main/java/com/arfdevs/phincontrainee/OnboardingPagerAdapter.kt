package com.arfdevs.phincontrainee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.arfdevs.phincontrainee.databinding.FragmentOnboardingBinding
import com.arfdevs.phincontrainee.databinding.ItemOnboardingImageBinding

class OnboardingPagerAdapter(private val imageList: List<Int>): RecyclerView.Adapter<OnboardingPagerAdapter.OnboardingViewHolder>() {
    class OnboardingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_iv_onboarding)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_onboarding_image,
            parent,
            false
        )

        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        imageList[position].let {
            holder.imageView.setImageResource(it)
        }
    }

    override fun getItemCount(): Int = imageList.size
}