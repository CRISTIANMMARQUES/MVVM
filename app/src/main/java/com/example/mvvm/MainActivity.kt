package com.example.mvvm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonLogin.setOnClickListener(this)

        setObserver()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login){
            val email = binding.editEmail.text.toString() //estou guardando as informações que tem no campo email
            val password = binding.editPassaword.text.toString() //estou guardando as informações que tem no campo senha

            viewModel.doLogin(email, password)
        }
    }

    private fun setObserver(){
        viewModel.welcome().observe(this, Observer {
            binding.textWelcome.text = it
        })
        viewModel.login().observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext, "SUCESSO!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "Falha!", Toast.LENGTH_LONG).show()
            }
        })
    }


}