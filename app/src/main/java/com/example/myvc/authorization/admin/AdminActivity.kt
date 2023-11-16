@file:Suppress("DEPRECATION")

package com.example.myvc.authorization.admin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myvc.R
import com.example.myvc.authorization.admin.fragments.aCommunicateFragment
import com.example.myvc.authorization.admin.fragments.aHomeFragment
import com.example.myvc.authorization.admin.fragments.aLogoutFragment
import com.example.myvc.authorization.admin.fragments.aRegisterFragment
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
                .replace(R.id.frameLayout, aHomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_a_home)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_l_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aHomeFragment()).commit()
            R.id.nav_a_register -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aRegisterFragment()).commit()
            R.id.nav_a_communicate -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aCommunicateFragment()).commit()
            R.id.nav_a_logout -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, aLogoutFragment()).commit()//Toast.makeText(this, "Logged out Successfully", Toast.LENGTH_SHORT).show()
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