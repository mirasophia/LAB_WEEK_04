package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Top level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment,
                R.id.favoritesFragment,
                R.id.cafeFragment
            ),
            findViewById(R.id.drawer_layout) // untuk sinkron drawer
        )

        // Setup AppBar (toolbar) dengan NavController
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Setup Navigation Drawer
        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)

        // ✅ Setup Bottom Navigation
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            ?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
