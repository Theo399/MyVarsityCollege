@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.lecturer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authentication.LoginActivity
import com.example.myvc.authorization.lecturer.fragments.lApplicationFragment
import com.example.myvc.authorization.lecturer.fragments.lAssignmentsFragment
import com.example.myvc.authorization.lecturer.fragments.lCalendarFragment
import com.example.myvc.authorization.lecturer.fragments.lCoursesFragment
import com.example.myvc.authorization.lecturer.fragments.lDashboardFragment
import com.example.myvc.authorization.lecturer.fragments.lFeedbackFragment
import com.example.myvc.authorization.lecturer.fragments.lFilesFragment
import com.example.myvc.authorization.lecturer.fragments.lMessengerFragment
import com.example.myvc.authorization.lecturer.fragments.lStatusFragment
import com.example.myvc.databinding.ActivityLecturerBinding
import com.google.android.material.navigation.NavigationView

class LecturerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityLecturerBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLecturerBinding.inflate(layoutInflater)
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
                .replace(R.id.frameLayout, lDashboardFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_l_dashboard)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_l_dashboard -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lDashboardFragment()).commit()
            R.id.nav_l_calendar -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lCalendarFragment()).commit()
            R.id.nav_l_assignments -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lAssignmentsFragment()).commit()
            R.id.nav_l_files -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lFilesFragment()).commit()
            R.id.nav_l_courses -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lCoursesFragment()).commit()
            R.id.nav_l_messenger -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lMessengerFragment()).commit()
            R.id.nav_l_feedback -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lFeedbackFragment()).commit()
            R.id.nav_l_application -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lApplicationFragment()).commit()
            R.id.nav_l_status -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lStatusFragment()).commit()
            R.id.nav_l_logout -> startActivity(Intent(this@LecturerActivity, LoginActivity::class.java))
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