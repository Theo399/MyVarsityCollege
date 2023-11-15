package com.example.myvc.authorization.student.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myvc.R


class sQueryFragment : Fragment() {
    private lateinit var webViewQuery: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_s_query, container, false)

        // Initialize WebView
        webViewQuery = view.findViewById(R.id.webViewQuery)
        webViewQuery.settings.javaScriptEnabled = true // Enable JavaScript if needed
        webViewQuery.webViewClient = WebViewClient()

        // Load the URL
        webViewQuery.loadUrl("https://portal.varsitycollege.co.za/assist/student-hub/")

        return view
    }
}