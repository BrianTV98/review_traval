package com.example.reviewtraval.ui.register

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.reviewtraval.BR
import com.example.reviewtraval.R
import com.example.reviewtraval.data.api.ApiService
import com.example.reviewtraval.data.api.response.CreateUserResponse
import com.example.reviewtraval.databinding.FragmentRegisterBinding
import com.example.reviewtraval.utils.isEmailValid
import com.example.reviewtraval.utils.isPasswordValid
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Response
import java.security.Provider

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment(), RegisterListener {

    lateinit var binding : FragmentRegisterBinding
    val viewModel : RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //viewModel= ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_register, container, false)

        binding.viewModel =viewModel
        binding.setVariable(BR.registerListener, this)
        binding.lifecycleOwner= viewLifecycleOwner
        return binding.root
    }

    override fun btnLogin(view: View) {

        Toast.makeText(context,"username "+ viewModel.registerModel.value?.username, Toast.LENGTH_SHORT).show()
        if(checkValid()){
            val dataService = ApiService.getService()
            val callBack= dataService.createUserName(
                binding.registerEditUsername.text.toString(),
                binding.registerEditPassword.text.toString(),
                binding.registerEditFirstName.text.toString(),
                binding.registerEditLastName.text.toString(),
                binding.registerEditEmail.text.toString()
            )
            callBack.enqueue(object : retrofit2.Callback<CreateUserResponse>{
                override fun onFailure(call: Call<CreateUserResponse>, t: Throwable) {
                    Log.d("create user", "fail connect")
                }

                override fun onResponse(
                    call: Call<CreateUserResponse>,
                    response: Response<CreateUserResponse>
                ) {
                    val createUserResponse = response.body()
                    when(response.code()){
                        201->{
                            Toast.makeText(context, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
                            Handler().postDelayed(
                                Runnable {
                                    findNavController().navigate(R.id.login2Fragment)
                                },
                                2000
                            )

                        }
                        302 ->{
                            binding.registerLoEmail.helperText= createUserResponse?.exist
                        }
                    }
                }

            })
        }
    }

    /*
        check usename >6 word
        check password
        check first name not empty
        check last name not empty
        check is email
     */
    private fun checkValid() : Boolean{
        var check =true
        if(binding.registerEditUsername.text.toString().isEmpty()){
            binding.registerLoUsername.error =getString(R.string.not_empty)
            check= false
        }

        if(!binding.registerEditPassword.text.toString().isPasswordValid()){
            binding.registerLoPassword.error = getString(R.string.not_password)
            check=false
        }

        if(binding.registerEditFirstName.text.toString().isEmpty()){
            binding.registerLoFirstName.error =getString(R.string.not_empty)
            check= false
        }

        if(binding.registerEditLastName.text.toString().isEmpty()){
            binding.registerLoLastName.error =getString(R.string.not_empty)
            check= false
        }

        if(!binding.registerEditEmail.text.toString().isEmailValid()){
            binding.registerLoEmail.error =getString(R.string.not_email)
            check= false
        }

        return check
    }

}
