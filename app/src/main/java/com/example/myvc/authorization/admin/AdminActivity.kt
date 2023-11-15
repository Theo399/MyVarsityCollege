@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.admin

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authorization.admin.fragments.AnnouncementFragment
import com.example.myvc.authorization.admin.fragments.AssistFragment
import com.example.myvc.authorization.admin.fragments.CommunicateFragment
import com.example.myvc.authorization.admin.fragments.HomeFragment
import com.example.myvc.authorization.admin.fragments.MarkFragment
import com.example.myvc.authorization.admin.fragments.MonitorFragment
import com.example.myvc.authorization.admin.fragments.ReminderFragment
import com.example.myvc.authorization.admin.fragments.ReportFragment
import com.example.myvc.authorization.admin.fragments.ScheduleFragment
import com.example.myvc.databinding.ActivityAdminBinding
import com.google.android.material.navigation.NavigationView

class AdminActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityAdminBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
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
            R.id.nav_announcement -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, AnnouncementFragment()).commit()
            R.id.nav_monitor -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, MonitorFragment()).commit()
            R.id.nav_schedule -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ScheduleFragment()).commit()
            R.id.nav_report -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ReportFragment()).commit()
            R.id.nav_communicate -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, CommunicateFragment()).commit()
            R.id.nav_mark -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, MarkFragment()).commit()
            R.id.nav_assist -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, AssistFragment()).commit()
            R.id.nav_reminder -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ReminderFragment()).commit()
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