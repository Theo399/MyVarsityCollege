package com.example.myvc.authorization.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myvc.authentication.adapter.ExtensionAdapter
import com.example.myvc.authentication.database.databaseHelper.ExtensionDBHelper
import com.example.myvc.databinding.ActivityStraceBinding

class sTraceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStraceBinding
    private lateinit var db: ExtensionDBHelper
    private lateinit var eAdapter: ExtensionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStraceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ExtensionDBHelper(this)
        eAdapter = ExtensionAdapter(db.displayExtension(), this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = eAdapter
    }

    override fun onResume() {
        super.onResume()
        eAdapter.refreshExtension(db.displayExtension())
    }
}