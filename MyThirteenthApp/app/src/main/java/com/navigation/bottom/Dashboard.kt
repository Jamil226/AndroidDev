package com.navigation.bottom

import android.os.Bundle
import android.content.res.Configuration.*
import android.view.WindowManager
import androidx.core.content.ContextCompat
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.navigation.bottom.databinding.ActivityDashboardBinding
import com.navigation.bottom.fragments.AboutFragment
import com.navigation.bottom.fragments.ContactFragment
import com.navigation.bottom.fragments.HomeFragment

class Dashboard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding:ActivityDashboardBinding
    private lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val statusBarColor = if (isDarkMode()) {
            ContextCompat.getColor(window.context, R.color.black)

        } else {
            ContextCompat.getColor(window.context, R.color.blue_900)

        }

        val toggle = ActionBarDrawerToggle(this,
            binding.drawerLayout, binding.toolbar,
            R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.setOnItemSelectedListener {
            item -> when(item.itemId){
            R.id.nav_bottom_home -> openFragment(HomeFragment())
            R.id.nav_bottom_about -> openFragment(AboutFragment())
            R.id.nav_bottom_contact -> openFragment(ContactFragment())
            }
            true
        }

        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> openFragment(HomeFragment())
            R.id.nav_about -> openFragment(AboutFragment())
            R.id.nav_contact -> openFragment(ContactFragment())
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressedDispatcher.onBackPressed()
        }
        super.onBackPressed()
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

    private fun isDarkMode(): Boolean {
        return when (this.resources.configuration.uiMode and UI_MODE_NIGHT_MASK) {
            UI_MODE_NIGHT_YES -> true
            else -> false
        }
    }

}