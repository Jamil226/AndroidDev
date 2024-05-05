package com.mac.jamil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.navigation.NavigationView
import com.mac.jamil.database.InventoryDatabase
import com.mac.jamil.databinding.ActivityMainBinding
import com.mac.jamil.entities.Categories
import com.mac.jamil.fragments.AboutFragment
import com.mac.jamil.fragments.CategoriesFragment
import com.mac.jamil.fragments.HomeFragment
import com.mac.jamil.fragments.SettingsFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.nav_open,
            R.string.nav_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            binding.navView.setCheckedItem(R.id.nav_home)
        }

//        database = InventoryDatabase.getDatabase(this)
//        GlobalScope.launch {
//            database.studentDAO()
//                .insertCategory(
//                    Categories(
//                        0,
//                        "Grilled",
//                        "The chicken is often tender and has brown grill marks, which adds an extra layer of umami flavor with a crisped texture. Grilled chicken can be served as is, or an a salad, sandwich or any other variety of dishes.",
//                        Date(),
//                        1
//                    )
//                )
//        }

//        binding.btnSubmit.setOnClickListener {
//            database.studentDAO().getCategories().observe(this, Observer{
//                Log.d("Categories", it.toString())
//            })
//        }

    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.nav_home -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, HomeFragment()).commit()
//
//            R.id.nav_settings -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, SettingsFragment()).commit()
//
////            R.id.nav_share -> supportFragmentManager.beginTransaction()
////                .replace(R.id.fragment_container, ShareFragment()).commit()
//
//            R.id.nav_about -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, AboutFragment()).commit()
//
//            R.id.nav_logout ->  {
//            Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, Login::class.java))
//            }
//        }
//        binding.drawerLayout.closeDrawer(GravityCompat.START)
//        return true
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_categories -> replaceFragment(CategoriesFragment())
            R.id.nav_settings -> replaceFragment(SettingsFragment())
            R.id.nav_share -> {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Check out this cool app on google play!")
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
            R.id.nav_about -> replaceFragment(AboutFragment())
            R.id.nav_logout -> {
                Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Login::class.java))
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}