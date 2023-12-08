@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.admin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authentication.LoginActivity
import com.example.myvc.authentication.RegisterActivity
import com.example.myvc.authorization.admin.fragments.aApplicationFragment
import com.example.myvc.authorization.admin.fragments.aDashboardFragment
import com.example.myvc.authorization.admin.fragments.aTimetablesFragment
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
                .replace(R.id.frameLayout, aDashboardFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_a_dashboard)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_a_dashboard -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aDashboardFragment()).commit()
            //R.id.nav_a_calendar -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, aCalendarFragment()).commit()
            //R.id.nav_a_files -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, aFilesFragment()).commit()
            //R.id.nav_a_courses -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, aCoursesFragment()).commit()
            //R.id.nav_a_team -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, aTeamFragment()).commit()
            //R.id.nav_a_messenger -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, aMessengerFragment()).commit()
            //R.id.nav_a_feedback -> supportFragmentManager.beginTransaction()
                //.replace(R.id.frameLayout, aFeedbackFragment()).commit()
            R.id.nav_a_user -> startActivity(Intent(this@AdminActivity, RegisterActivity::class.java))
            R.id.nav_a_timetables -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aTimetablesFragment()).commit()
            R.id.nav_a_application -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aApplicationFragment()).commit()
            R.id.nav_a_logout -> startActivity(Intent(this@AdminActivity, LoginActivity::class.java))//Toast.makeText(this, "Logged out Successfully", Toast.LENGTH_SHORT).show()
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