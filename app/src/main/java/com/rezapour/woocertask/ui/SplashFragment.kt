package com.rezapour.woocertask.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rezapour.woocertask.R
import com.rezapour.woocertask.databinding.FragmentSplashBinding
import java.util.*


class SplashFragment : Fragment() {
    var _binding: FragmentSplashBinding? = null
    val binding get() = _binding!!
    private var navControler: NavController? = null

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
        timer()
    }

    private fun timer() {
        Handler().postDelayed({
            navControler!!.navigate(R.id.action_splashFragment_to_loginFragment)
        }, 2000)
    }
}