package com.example.okcredit_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val headerView: View = navigation_view.getHeaderView(0)

        headerView.setOnClickListener {

            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()

        }

        setSupportActionBar(toolBar)
        val navHostFragment =supportFragmentManager.findFragmentById(R.id.home_nav_graph) as NavHostFragment
        navController=navHostFragment.navController
        appBarConfig= AppBarConfiguration(navController.graph,drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfig)
        navigation_view.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig)||super.onSupportNavigateUp()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menu,menu)
//        val search=menu?.findItem(R.id.menu_search)
//        val searchView=search?.actionView as SearchView
//        searchView.queryHint="Search Something!"
//        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//            override fun onQueryTextChange(p0: String?): Boolean {
//              return false
//            }
//
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//              return true
//            }
//        })
//
//        return super.onCreateOptionsMenu(menu)
//    }

}