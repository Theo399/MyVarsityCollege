@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.lecturer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authorization.lecturer.fragments.lCommunicateFragment
import com.example.myvc.authorization.lecturer.fragments.lHomeFragment
import com.example.myvc.authorization.lecturer.fragments.lLogoutFragment
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
                .replace(R.id.frameLayout, lHomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_l_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_l_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lHomeFragment()).commit()
            R.id.nav_l_communicate -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lCommunicateFragment()).commit()
            R.id.nav_l_logout -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, lLogoutFragment()).commit()
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