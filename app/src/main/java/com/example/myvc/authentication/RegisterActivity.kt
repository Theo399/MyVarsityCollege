package com.example.myvc.authentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myvc.authentication.database.Credentials
import com.example.myvc.authorization.admin.AdminActivity
import com.example.myvc.databinding.ActivityRegisterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("credentials")

        binding.registerBtn.setOnClickListener {
            binding.registerBtn.setBackgroundColor(Color.BLUE)
            binding.registerBtn.setTextColor(Color.WHITE)

            val username = binding.username.text.toString()
            val role = binding.role.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (username.isNotEmpty() && role.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                register(username, email, password, role)
            } else {
                Toast.makeText(this@RegisterActivity, "Fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

       /* binding.haveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            Toast.makeText(this@RegisterActivity, "Please Login", Toast.LENGTH_SHORT).show()
            finish()
        }*/
    }

    private fun register(username: String, email: String, password: String, role: String) {
        databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.exists()) {
                    val id = databaseReference.push().key
                    val userCredentials = Credentials(id, username, email, password, role)
                    databaseReference.child(id!!).setValue(userCredentials)
                    Toast.makeText(this@RegisterActivity, "Registered Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@RegisterActivity, AdminActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@RegisterActivity, "User Already Exists", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RegisterActivity, "Database Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}