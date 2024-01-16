package com.arfdevs.phincontrainee

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arfdevs.phincontrainee.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //yellow shape anim
        animate(binding.ivShapeYellow, ROTATE_ANIMATION, 0f, -26f)
        animate(binding.ivShapeYellow, TRANSLATION_X, 0f, -80f)
        animate(binding.ivShapeYellow, TRANSLATION_Y, 0f, -88f)

        //red shape anim
        animate(binding.ivShapeRed, ROTATE_ANIMATION, 0f, 27f)
        animate(binding.ivShapeRed, TRANSLATION_X, 0f, 80f)
        animate(binding.ivShapeRed, TRANSLATION_Y, 0f, -79f)

        //green shape
        animate(binding.ivShapeGreen, TRANSLATION_Y, 0f, -160f)
    }

    private fun animate(view: View, propertyName: String, startVal: Float, endVal: Float, duration: Long = 1500) {
        view.run {
            when {
                propertyName.equals(TRANSLATION_X, true) -> {
                    ObjectAnimator.ofFloat(view, View.TRANSLATION_X, startVal, endVal).apply {
                        this.duration = duration
                    }.start()
                }

                propertyName.equals(TRANSLATION_Y, true) -> {
                    ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, startVal, endVal).apply {
                        this.duration = duration
                    }.start()
                }

                propertyName.equals(SCALE_X, true) -> {
                    ObjectAnimator.ofFloat(view, View.SCALE_X, startVal, endVal).apply {
                        this.duration = duration
                    }.start()
                }

                propertyName.equals(SCALE_Y, true) -> {
                    ObjectAnimator.ofFloat(view, View.SCALE_Y, startVal, endVal).apply {
                        this.duration = duration
                    }.start()
                }

                propertyName.equals(ROTATE_ANIMATION, true) -> {
                    ObjectAnimator.ofFloat(view, View.ROTATION, startVal, endVal).apply {
                        this.duration = duration
                    }.start()
                }

                propertyName.equals(ALPHA_ANIMATION, true) -> {
                    ObjectAnimator.ofFloat(view, View.ALPHA, startVal, endVal).apply {
                        this.duration = duration
                    }.start()
                }

                else -> {
                    val marginParams = view.layoutParams as LinearLayout.LayoutParams
                    marginParams.setMargins(0, 0, 0, 60)
                }
            }
        }
    }

//    private fun animate_valueAnim(view: View, propertyName: String, startVal: Float, endVal: Float, duration: Long = 1500) {
//        val animator = ValueAnimator.ofFloat(startVal, endVal)
//
//        animator.duration = duration
//        val animatedValue = animator.animatedValue as Float
//
//        animator.addUpdateListener {
//            view.alpha = animatedValue
//        }
//    }

    companion object {
        const val TRANSLATION_X = "translation_x"
        const val TRANSLATION_Y = "translation_y"
        const val SCALE_X = "scale_x"
        const val SCALE_Y = "scale_y"
        const val ROTATE_ANIMATION = "rotate_animation"
        const val ALPHA_ANIMATION = "alpha_animation"
    }
}