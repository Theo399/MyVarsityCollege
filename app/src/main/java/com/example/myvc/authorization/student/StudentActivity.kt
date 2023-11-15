@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.student

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authorization.home.HomeFragment
import com.example.myvc.authorization.student.fragments.sLearningFragment
import com.example.myvc.authorization.student.fragments.sMarkFragment
import com.example.myvc.authorization.student.fragments.sQueryFragment
import com.example.myvc.authorization.student.fragments.sSubmitFragment
import com.example.myvc.databinding.ActivityStudentBinding
import com.google.android.material.navigation.NavigationView

class StudentActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityStudentBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout

        val toolBar = binding.toolBar
        setSupportActionBar(toolBar)

        val navigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HomeFragment()).commit()
            R.id.nav_submit -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sSubmitFragment()).commit()
            R.id.nav_query -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sQueryFragment()).commit()
            R.id.nav_mark -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sMarkFragment()).commit()
            R.id.nav_learning -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sLearningFragment()).commit()
            R.id.logoutBtn -> Toast.makeText(this, "Logged out Successfully", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
        super.onBackPressed()
    }
}