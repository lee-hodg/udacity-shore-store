package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Timber.plant(Timber.DebugTree())

        // when within activity get navController like this
        val navController = this.findNavController(R.id.nav_host_fragment)

        // Setup action bar and navigation like this
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        // ensure that up button actually works
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}
