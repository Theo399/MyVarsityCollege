package com.example.myvc.authorization.student.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.myvc.R


class sLearningFragment : Fragment() {
    private lateinit var webViewAccessLearning: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_s_learning, container, false)

        // Initialize WebView
        webViewAccessLearning = view.findViewById(R.id.webViewAccessLearning)
        webViewAccessLearning.settings.javaScriptEnabled = true // Enable JavaScript if needed
        webViewAccessLearning.webViewClient = WebViewClient()

        // Load the URL
        webViewAccessLearning.loadUrl("https://iielibraryconnect.iie.ac.za/e-shelf")

        return view
    }
}