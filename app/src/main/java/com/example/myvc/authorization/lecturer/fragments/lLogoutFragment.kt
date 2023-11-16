package com.example.myvc.authorization.lecturer.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myvc.R
import com.example.myvc.authentication.LoginActivity

class lLogoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_l_logout, container, false)

        val button: Button = view.findViewById(R.id.logoutBtn)

        button.setOnClickListener {
            button.setBackgroundColor(Color.BLUE)
            button.setTextColor(Color.WHITE)

            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}