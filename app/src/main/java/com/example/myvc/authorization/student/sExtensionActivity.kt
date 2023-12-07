package com.example.myvc.authorization.student

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myvc.authentication.database.Extension
import com.example.myvc.authentication.database.databaseHelper.ExtensionDBHelper
import com.example.myvc.databinding.ActivitySextensionBinding

class sExtensionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySextensionBinding
    private lateinit var db: ExtensionDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySextensionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ExtensionDBHelper(this)

        binding.submitBtn.setOnClickListener {
            val fullName = binding.fullName.text.toString()
            val campus = binding.campus.text.toString()
            val delivery = binding.delivery.text.toString()
            val registration = binding.registration.text.toString()
            val qualification = binding.qualification.text.toString()
            val reason = binding.reason.text.toString()
            val previous = binding.previous.text.toString()
            val assessment1 = binding.assessment1.text.toString()
            val missed = binding.missed.text.toString()
            val assessment2 = binding.assessment2.text.toString()
            val replacement = binding.replacement.text.toString()
            val module = binding.module.text.toString()
            val status = "Approved"

            val limit = db.findExtension(fullName)
            if (limit != 2) {
                val userExtension = Extension(
                    0,
                    fullName,
                    campus,
                    delivery,
                    registration,
                    qualification,
                    reason,
                    previous,
                    assessment1,
                    missed,
                    assessment2,
                    replacement,
                    module,
                    status
                )
                db.insertExtension(userExtension)
                Toast.makeText(this, "Ticket Sent Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You have reached your limit", Toast.LENGTH_SHORT).show()
            }
            /*
            val userExtension = Extension(
                0,
                fullName,
                campus,
                delivery,
                registration,
                qualification,
                reason,
                previous,
                assessment1,
                missed,
                assessment2,
                replacement,
                module,
                status
            )
            db.insertExtension(userExtension)
            Toast.makeText(this, "Approved", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, sTraceActivity::class.java))
            finish()*/
        }
    }
}