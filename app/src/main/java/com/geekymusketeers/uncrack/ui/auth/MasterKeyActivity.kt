package com.geekymusketeers.uncrack.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.geekymusketeers.uncrack.R
import com.geekymusketeers.uncrack.databinding.ActivityMasterKeyBinding
import com.geekymusketeers.uncrack.databinding.ActivitySplashBinding
import com.geekymusketeers.uncrack.ui.auth.fragment.CreateMasterKeyFragment
import com.geekymusketeers.uncrack.ui.fragments.account.HomeFragment
import com.geekymusketeers.uncrack.ui.fragments.card.CardFragment

class MasterKeyActivity : AppCompatActivity() {

    lateinit var binding: ActivityMasterKeyBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasterKeyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hides action bar
        supportActionBar?.hide()

        val flow = intent.getStringExtra("flow")

        setupNavigation()

        if (flow == "createMasterKey") {
            findNavController(R.id.key_fragment).navigate(R.id.masterKeyFragment)
        }
        if (flow == "askForMasterKey") {
            findNavController(R.id.key_fragment).navigate(R.id.lockMasterKeyFragment)
        }
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.key_fragment) as NavHostFragment
        navController = navHostFragment.navController

    }


}