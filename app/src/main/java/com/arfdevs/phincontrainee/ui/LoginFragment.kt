package com.arfdevs.phincontrainee.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arfdevs.phincontrainee.R
import com.arfdevs.phincontrainee.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            etEmail.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    s?.let {
                        tiEmail.apply {
                            when {
                                !Patterns.EMAIL_ADDRESS.matcher(it)
                                    .matches() && it.isNotBlank() -> {
                                    isHelperTextEnabled = false
                                    error = resources.getString(R.string.error_text_email)
                                    isErrorEnabled = true
                                }

                                it.isBlank() -> {
                                    isHelperTextEnabled = false
                                    error = resources.getString(R.string.error_text_email_blank)
                                    isErrorEnabled = true
                                }

                                else -> {
                                    isHelperTextEnabled = true
                                    isErrorEnabled = false
                                }
                            }
                        }
                    }
                }

            })

            etPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    //password pattern matching criteria
                    //val pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[;,:.!?$%^*()-_+=])[A-Za-z\\d;,:.!?$%^*()-_+=]{8,}$"))

                    s?.let {
                        tiPassword.apply {
                            when {
                                /*!pattern.matcher(it).matches() && it.isNotBlank() -> {
                                    isHelperTextEnabled = false
                                    error = resources.getString(R.string.error_text_password)
                                    isErrorEnabled = true
                                }*/

                                it.length < 8 && it.isNotBlank() -> {
                                    isHelperTextEnabled = false
                                    error = resources.getString(R.string.error_text_password)
                                    isErrorEnabled = true
                                }

                                it.isBlank() -> {
                                    isHelperTextEnabled = false
                                    error = resources.getString(R.string.error_text_password_blank)
                                    isErrorEnabled = true
                                }

                                else -> {
                                    isHelperTextEnabled = true
                                    isErrorEnabled = false
                                }
                            }
                        }
                    }
                }

            })

            btnLogin.setOnClickListener {
                Snackbar.make(
                    view,
                    "Logged in!",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            btnRegister.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, RegisterFragment())
                    .commit()
            }
        }
    }

}