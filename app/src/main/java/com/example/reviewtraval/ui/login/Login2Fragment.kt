package com.example.reviewtraval.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.reviewtraval.BR
import com.example.reviewtraval.R
import com.example.reviewtraval.data.api.ApiService
import com.example.reviewtraval.data.api.response.LoginResponse
import com.example.reviewtraval.databinding.FragmentLogin2Binding
import com.example.reviewtraval.utils.token
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class Login2Fragment : Fragment(), LoginListener {

    lateinit var binding : FragmentLogin2Binding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel= ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_login2, container,false)
//
        binding.setVariable(BR.loginListern, this)
       // binding.setVariable(BR.loginViewModel, this)

       // binding.loginViewModel = viewModel

        binding.lifecycleOwner =viewLifecycleOwner

//         Inflate the layout for this fragmen
        Log.d("Login","True")
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
//            viewModel.refuseAuthentication()
//            navController.popBackStack(R.id.main_fragment, false)
//        })

        val navController = findNavController()
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> findNavController().navigate(R.id.newFeedFragment)
            }
        })
        return binding.root
    }

    override fun btnLogin(view: View) {
        val dataApiService = ApiService.getService()
        val username =binding.loginEditUsername.text.toString().trim()
        val password =  binding.loginEditPaswword.text.toString().trim()

        Log.d("user name", username + password)
        val callBack = dataApiService.login(username, password)

        callBack.enqueue(object : retrofit2.Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(context, "Fail",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body() as LoginResponse
                when(response.code()){
                    200 ->{
                        token = loginResponse.api_token
                        viewModel._authenticationState.value = LoginViewModel.AuthenticationState.AUTHENTICATED
                    }

                    203 ->{
                        binding.loginInputLoPassword.helperText =loginResponse.error
                    }

                    428 ->{
                        binding.loginInputLoPassword.helperText =loginResponse.required
                        binding.loginEditUsername.requestFocus()
                    }
                }

            }

        })
    }

    override fun checkbox(view: View) {
        TODO("not implemented") //To chang  e body of created functions use File | Settings | File Templates.
    }

}
