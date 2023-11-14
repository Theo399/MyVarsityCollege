package com.example.myvc.authentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myvc.authentication.database.Credentials
import com.example.myvc.authorization.admin.AdminActivity
import com.example.myvc.authorization.lecturer.LecturerActivity
import com.example.myvc.authorization.student.StudentActivity
import com.example.myvc.databinding.ActivityLoginBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("credentials")

        binding.loginBtn.setOnClickListener {
            binding.loginBtn.setBackgroundColor(Color.BLUE)
            binding.loginBtn.setTextColor(Color.WHITE)

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                login(email, password)
            } else {
                Toast.makeText(this@LoginActivity, "Fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.noAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            Toast.makeText(this, "Please Register", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun login (email: String, password: String) {

        val role1 = "Admin"
        val role2 = "Lecturer"
        val role3 = "Student"

        databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val userCredentials = userSnapshot.getValue(Credentials::class.java)
                        if (userCredentials != null && userCredentials.password == password && userCredentials.role == role1) {
                            Toast.makeText(this@LoginActivity, "Logged in Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, AdminActivity::class.java))
                            finish()
                        } else if (userCredentials != null && userCredentials.password == password && userCredentials.role == role2) {
                            Toast.makeText(this@LoginActivity, "Logged in Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, LecturerActivity::class.java))
                            finish()
                        } else if (userCredentials != null && userCredentials.password == password && userCredentials.role == role3) {
                            Toast.makeText(this@LoginActivity, "Logged in Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, StudentActivity::class.java))
                            finish()
                        }
                        return
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@LoginActivity, "Database Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}