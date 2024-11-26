package com.holtihealth.app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.holtihealth.app.databinding.ActivityMainBinding
import com.holtihealth.app.ui.article.ArticleFragment
import com.holtihealth.app.ui.history.HistoryFragment
import com.holtihealth.app.ui.home.HomeFragment
import com.holtihealth.app.ui.profile.ProfileFragment
import com.holtihealth.app.ui.scan.CameraActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast("Permission request granted")
            } else {
                showToast("Permission request denied")
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }

        binding.fab.setOnClickListener { startCameraX()}

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

    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }

}
