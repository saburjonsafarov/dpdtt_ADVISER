package tj.kpittu.adviser.modules.authentication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tj.kpittu.adviser.R
import tj.kpittu.adviser.modules.authentication.vm.LoginFragmentViewModel
import tj.kpittu.adviser.modules.main.view.MainActivity


class LoginFragment : Fragment(),View.OnClickListener {
    private lateinit var viewModel:LoginFragmentViewModel
    private lateinit var usernameEditText:EditText
    private lateinit var passwordEditText:EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(LoginFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_login , container , false)
            usernameEditText = view.findViewById<EditText>(R.id.usernameEditText)
            passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
            view.findViewById<Button>(R.id.voridButton).setOnClickListener(this)
        return view
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        viewModel.getMessage().observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext() , it , Toast.LENGTH_SHORT).show()
        })
        if(viewModel.getLogin() != null && viewModel.getPassword() != null){
            viewModel.validate(viewModel.getLogin()!!,viewModel.getPassword()!!).observe(viewLifecycleOwner,{
                if (it){
                    val intent = Intent(requireActivity(),MainActivity::class.java)
                    startActivity(intent)
                }
            })


        }
    }

    override fun onClick(p0: View?) {
        val login = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        viewModel.validate(login,password).observe(viewLifecycleOwner,{
            if (it){
                val intent = Intent(requireActivity(),MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}