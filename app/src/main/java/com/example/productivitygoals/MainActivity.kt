package com.example.productivitygoals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.productivitygoals.databinding.ActivityMainBinding
import com.example.productivitygoals.ui.CategoriesFragment
import com.example.productivitygoals.ui.GoalListFragment
import com.example.productivitygoals.ui.ReportFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

//    private val onNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.list_of_goals -> {
////                    replaceFragment(GoalListFragment.newInstance())
//                    navController.navigate(R.id.goalListFragment)
//                    true
//                }
//                R.id.report_of_goals -> {
//                    navController.navigate(R.id.report_of_goals)
//                    true
//                }
//            }
//            false
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

//        replaceFragment(GoalListFragment.newInstance())
        binding.bottomNav.setupWithNavController(navController)
//        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        drawerToggle =
            ActionBarDrawerToggle(this, binding.drawer, R.string.nav_open, R.string.nav_close)

        binding.drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setUpDrawer()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpDrawer() {
        binding.navigationViewDrawer.setNavigationItemSelectedListener { menuItem ->
            navigateToDrawerItem(menuItem)
            true
        }
    }

    private fun navigateToDrawerItem(item: MenuItem) {
        when (item.itemId) {
            R.id.drawer_menu_goals -> {
//                replaceFragment(GoalListFragment.newInstance())
                navController.navigate(R.id.list_of_goals)
            }
            R.id.drawer_menu_categories -> {
                navController.navigate(R.id.categoriesFragment)
            }
        }
        binding.drawer.closeDrawers()
    }

//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, fragment).commit()
//    }
}