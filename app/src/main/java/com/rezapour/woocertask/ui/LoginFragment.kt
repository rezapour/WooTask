package com.rezapour.woocertask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rezapour.woocertask.databinding.FragmentLoginBinding
import com.rezapour.woocertask.model.user.User
import com.rezapour.woocertask.util.DataState
import com.rezapour.woocertask.viewmodel.LoginViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var navControler: NavController? = null

    private val viewmodel: LoginViewmodel by viewModels()

    private lateinit var btnSingUp: Button
    private lateinit var etName: TextView
    private lateinit var etEmail: TextView
    private lateinit var etWebsite: TextView
    private lateinit var etConsumerKey: TextView
    private lateinit var etConsumerSecret: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler = Navigation.findNavController(view)
        setupUi()
        setUpObserver()
    }

    private fun setUpObserver() {
        viewmodel.dataState.observe(viewLifecycleOwner) { dataState ->

            when (dataState) {
                is DataState.Success -> {
                    Toast.makeText(context, "save", Toast.LENGTH_LONG).show()
                }
                is DataState.Error -> {
                    Toast.makeText(context, dataState.message, Toast.LENGTH_LONG).show()
                }
                is DataState.Loading -> {

                }

            }

        }
    }

    private fun setupUi() {
        btnSingUp = binding.btnSingUo
        etName = binding.etName
        etEmail = binding.etEmail
        etWebsite = binding.etwebsite
        etConsumerKey = binding.etConsumerKey
        etConsumerSecret = binding.etConsumerSecret

        btnSingUp.setOnClickListener({
//            navControler!!.navigate(R.id.action_loginFragment_to_mainFragment)
            saveUser()

        })

    }

    private fun saveUser() {
        viewmodel.saveUser(User(
            name="reza",
            email = "reza@gamil.com",
            webSite = "reza.com",
            consumerKey = "ck_12345",
            consumerSecret = "cs_1234"
        )

//            User(
//                name = etName.text.toString(),
//                email = etEmail.text.toString(),
//                webSite = etWebsite.text.toString(),
//                consumerSecret = etConsumerSecret.text.toString(),
//                consumerKey = etConsumerKey.text.toString()
//            )
        )
    }


}