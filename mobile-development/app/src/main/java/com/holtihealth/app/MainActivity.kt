package com.holtihealth.app

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.holtihealth.app.databinding.ActivityMainBinding
import com.holtihealth.app.ui.article.ArticleFragment
import com.holtihealth.app.ui.history.HistoryFragment
import com.holtihealth.app.ui.home.HomeFragment
import com.holtihealth.app.ui.profile.ProfileFragment
import com.holtihealth.app.ui.scan.ScanFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.fab.setOnClickListener{
            openFragment(ScanFragment())
            supportActionBar?.title = "Scan"
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    openFragment(HomeFragment())
                    supportActionBar?.title = "Home"
                    true
                }

                R.id.navigation_history -> {
                    openFragment(HistoryFragment())
                    supportActionBar?.title = "History"
                    true
                }
                R.id.navigation_scan -> {
                    openFragment(ScanFragment())
                    supportActionBar?.title = "Scan"
                    true
                }
                R.id.navigation_article -> {
                    openFragment(ArticleFragment())
                    supportActionBar?.title = "Article"
                    true
                }
                R.id.navigation_profile -> {
                    openFragment(ProfileFragment())
                    supportActionBar?.title = "Profile"
                    true
                }

                else -> false
            }
        }

    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}
