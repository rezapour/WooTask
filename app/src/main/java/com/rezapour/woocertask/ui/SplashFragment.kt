package com.rezapour.woocertask.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rezapour.woocertask.R
import com.rezapour.woocertask.databinding.FragmentSplashBinding
import com.rezapour.woocertask.viewmodel.LoginViewmodel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class SplashFragment : Fragment() {
    var _binding: FragmentSplashBinding? = null
    val binding get() = _binding!!
    private var navControler: NavController? = null
    val viewmodel: LoginViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler = Navigation.findNavController(view)

        setObserver()
    }

    private fun setObserver() {
        viewmodel.isLogin.observe(viewLifecycleOwner) {
            if (it == null) {
                Log.d("mainFragemtnTest", "notlogin")
                nextFragment(R.id.action_splashFragment_to_loginFragment)

            } else {
                Log.d("mainFragemtnTest", "login")
                nextFragment(R.id.action_splashFragment_to_mainFragment)
            }
        }
    }

    private fun nextFragment(actionId: Int) {
        Handler().postDelayed({
            navControler!!.navigate(actionId)
        }, 2000)
    }
}