package com.example.myvc.authorization.admin.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myvc.R
import com.example.myvc.authentication.RegisterActivity

class aRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a_register, container, false)

        val button: Button = view.findViewById(R.id.registerBtn)

        button.setOnClickListener {
            button.setBackgroundColor(Color.BLUE)
            button.setTextColor(Color.WHITE)

            val intent = Intent(requireContext(), RegisterActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}