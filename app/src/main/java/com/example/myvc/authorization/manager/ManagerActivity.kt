@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.manager

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authentication.LoginActivity
import com.example.myvc.authorization.manager.fragments.mApplicationFragment
import com.example.myvc.authorization.manager.fragments.mCoursesFragment
import com.example.myvc.authorization.manager.fragments.mDashboardFragment
import com.example.myvc.authorization.manager.fragments.mStatusFragment
import com.example.myvc.databinding.ActivityManagerBinding
import com.google.android.material.navigation.NavigationView

class ManagerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityManagerBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerBinding.inflate(layoutInflater)
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
                .replace(R.id.frameLayout, mDashboardFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_m_dashboard)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_m_dashboard -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, mDashboardFragment()).commit()
            //R.id.nav_m_calendar -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mCalendarFragment()).commit()
            //R.id.nav_m_files -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mFilesFragment()).commit()
            R.id.nav_m_courses -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, mCoursesFragment()).commit()
            //R.id.nav_m_team -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mTeamFragment()).commit()
            //R.id.nav_m_messenger -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mMessengerFragment()).commit()
            //R.id.nav_m_feedback -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mFeedbackFragment()).commit()
            //R.id.nav_m_application -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mApplicationFragment()).commit()
            //R.id.nav_m_status -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, mStatusFragment()).commit()
            R.id.nav_m_logout -> startActivity(Intent(this@ManagerActivity, LoginActivity::class.java))//Toast.makeText(this, "Logged out Successfully", Toast.LENGTH_SHORT).show()
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