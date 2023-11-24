@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.student

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authorization.student.fragments.sAssessmentFragment
import com.example.myvc.authorization.student.fragments.sAssignmentFragment
import com.example.myvc.authorization.student.fragments.sAvailabilityFragment
import com.example.myvc.authorization.student.fragments.sCommunicateFragment
import com.example.myvc.authorization.student.fragments.sHomeFragment
import com.example.myvc.authorization.student.fragments.sLogoutFragment
import com.example.myvc.authorization.student.fragments.sMarkFragment
import com.example.myvc.authorization.student.fragments.sMaterialFragment
import com.example.myvc.authorization.student.fragments.sQueryFragment
import com.example.myvc.authorization.student.fragments.sScheduleFragment
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
                .replace(R.id.frameLayout, sHomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_s_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_s_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sHomeFragment()).commit()
            R.id.nav_s_communicate -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sCommunicateFragment()).commit()
            R.id.nav_s_material -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sMaterialFragment()).commit()
            R.id.nav_s_query -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sQueryFragment()).commit()
            R.id.nav_s_assignment -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sAssignmentFragment()).commit()
            R.id.nav_s_mark -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sMarkFragment()).commit()
            R.id.nav_s_availability -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sAvailabilityFragment()).commit()
            R.id.nav_s_assessment -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sAssessmentFragment()).commit()
            R.id.nav_s_schedule -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sScheduleFragment()).commit()
            R.id.nav_s_logout -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, sLogoutFragment()).commit()
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