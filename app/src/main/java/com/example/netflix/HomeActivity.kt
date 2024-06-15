package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {

                R.id.home_btn -> {
                    changeFragment(HomeFragment(),"home")
                    toolbar.title ="Home"


                    true
                }
                R.id.profile_btn -> {
                    changeFragment(ProfileFragment(),"profile")
                    toolbar.title ="profile"

                    true
                }
                else -> false
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)

        return true
    }
    private fun changeFragment(fragment: Fragment, tag: String) {

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()

        if(tag.isNotEmpty()){
            fragmentTransaction.addToBackStack(tag)
        }
        fragmentTransaction.replace(R.id.fragmentContainerView2,fragment).commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_btn -> {
                val rootView = findViewById<View>(android.R.id.content)
                Snackbar.make(rootView, "Notification Clicked", Snackbar.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}