@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.student

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authentication.LoginActivity
import com.example.myvc.authorization.student.fragments.sApplicationFragment
import com.example.myvc.authorization.student.fragments.sAssignmentsFragment
import com.example.myvc.authorization.student.fragments.sCalendarFragment
import com.example.myvc.authorization.student.fragments.sCoursesFragment
import com.example.myvc.authorization.student.fragments.sDashboardFragment
import com.example.myvc.authorization.student.fragments.sFilesFragment
import com.example.myvc.authorization.student.fragments.sMembersFragment
import com.example.myvc.authorization.student.fragments.sStatusFragment
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
                .replace(R.id.frameLayout, sDashboardFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_s_dashboard)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_s_dashboard -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sDashboardFragment()).commit()
            R.id.nav_s_calendar -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sCalendarFragment()).commit()
            R.id.nav_s_members -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sMembersFragment()).commit()
            R.id.nav_s_files -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sFilesFragment()).commit()
            R.id.nav_s_courses -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sCoursesFragment()).commit()
            R.id.nav_s_assignments -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sAssignmentsFragment()).commit()
            R.id.nav_s_application -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sApplicationFragment()).commit()
            R.id.nav_s_status -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sStatusFragment()).commit()
            R.id.nav_s_logout -> startActivity(Intent(this@StudentActivity, LoginActivity::class.java))
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