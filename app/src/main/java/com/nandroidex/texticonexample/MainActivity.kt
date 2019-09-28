package com.nandroidex.texticonexample

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.nandroidex.texticon.FontDrawable
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var clicked = 0
        ftvSample.text = "click " + getString(R.string.fa_hand_pointer) + " anywhere to change"

        ftvSample.setOnClickListener {
            clicked++
            if (clicked == 0) {
                ftvSample.setTextColor(getColor(android.R.color.black))
                ftvSample.text =
                    "click " + getString(R.string.fa_hand_pointer) + " anywhere to change"
            } else if (clicked == 1) {
                ftvSample.text = "This is " + getString(R.string.fa_heart) + " heart"
            } else if (clicked == 2) {
                clicked = -1
                ftvSample.setTextColor(getColor(android.R.color.holo_red_light))
                ftvSample.text = "This is red " + getString(R.string.fa_heart) + " heart"
            }
        }

        initFab()
        intDrawerLayout()
    }

    /***
     * Changing FAB icon. FontDrawable is used to change the fab icon
     */
    private fun initFab() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        val drawable = FontDrawable(this, R.string.fa_paper_plane_solid, true, false)
        drawable.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        fab.setImageDrawable(drawable)
    }

    /**
     * Changing navigation drawer icons
     * This involves looping through menu items and applying icons
     */
    private fun intDrawerLayout() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val iconHeader =
            navigationView.getHeaderView(0).findViewById<AppCompatImageView>(R.id.nav_header_icon)
        val drawable = FontDrawable(this, R.string.fa_font_awesome, false, true)
        drawable.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        drawable.textSize = 50F
        iconHeader.setImageDrawable(drawable)

        val icons = intArrayOf(
            R.string.fa_home_solid,
            R.string.fa_calendar_alt_solid,
            R.string.fa_user_solid,
            R.string.fa_heart_solid,
            R.string.fa_comment_solid,
            R.string.fa_dollar_sign_solid,
            R.string.fa_gift_solid
        )
        renderMenuIcons(navigationView.menu, icons, true, false)

        val iconsSubmenu = intArrayOf(R.string.fa_cog_solid, R.string.fa_sign_out_alt_solid)

        // rending icons in second section group
        renderMenuIcons(navigationView.menu.getItem(7).subMenu, iconsSubmenu, true, false)
    }

    /**
     * Looping through menu icons are applying font drawable
     */
    private fun renderMenuIcons(menu: Menu, icons: IntArray, isSolid: Boolean, isBrand: Boolean) {
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            if (!menuItem.hasSubMenu()) {
                val drawable = FontDrawable(this, icons[i], isSolid, isBrand)
                drawable.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                drawable.textSize = 22F
                menu.getItem(i).icon = drawable
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}