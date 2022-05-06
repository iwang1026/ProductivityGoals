package com.example.productivitygoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.productivitygoals.GoalListFragment.Companion.newInstance
import com.example.productivitygoals.ReportFragment.Companion.newInstance
import com.example.productivitygoals.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.list_of_goals -> {
                replaceFragment(GoalListFragment.newInstance())
                true
            }
            R.id.report_of_goals -> {
                replaceFragment(ReportFragment.newInstance())
                true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(GoalListFragment.newInstance())
        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        drawerToggle = ActionBarDrawerToggle(this, binding.drawer, R.string.nav_open, R.string.nav_close)

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
        when(item.itemId) {
            R.id.drawer_menu_goals -> {
                replaceFragment(GoalListFragment.newInstance())
            }
            R.id.drawer_menu_categories -> {
                replaceFragment(CategoriesFragment.newInstance())
            }
        }
        binding.drawer.closeDrawers()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }
}