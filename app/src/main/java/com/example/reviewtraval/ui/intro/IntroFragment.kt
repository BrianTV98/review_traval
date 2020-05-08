package com.example.reviewtraval.ui.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.reviewtraval.BR
import com.example.reviewtraval.R
import com.example.reviewtraval.databinding.FragmentIntro2Binding

/**
 * A simple [Fragment] subclass.
 */
class IntroFragment : Fragment(), IntroListener {
    lateinit var binding  : FragmentIntro2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(layoutInflater, R.layout.fragment_intro2,container,false);
        val view : View = binding.root
        binding.setVariable(BR.introListener, this)
        return view
    }

    override fun btnLogin(view: View) {
        findNavController().navigate(R.id.action_introFragment_to_login2Fragment)
    }

    override fun btnRegister(view: View) {
        findNavController().navigate(R.id.action_introFragment_to_registerFragment)
    }

    override fun btnForgotPassword(view: View) {
        findNavController().navigate(R.id.action_introFragment_to_forgotFragment)
    }

}
