package com.anrsample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG_INFO = "info"
        private const val TAG_MAP = "map"
    }

    private var isInfoShowing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(InfoFragment(), TAG_INFO)
        findViewById<View>(R.id.btn_switch).setOnClickListener { switchFragments() }
    }

    private fun addFragment(fragment: InfoFragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl_container, fragment, tag)
            .commit()
    }

    private fun switchFragments() {
        if (isInfoShowing) showMapFragment() else showInfoFragment()
    }

    private fun showInfoFragment() {
        val infoFragment = supportFragmentManager.findFragmentByTag(TAG_INFO)!!
        replaceFragment(infoFragment, TAG_INFO, false)
    }

    private fun showMapFragment() {
        val mapFragment = supportFragmentManager.findFragmentByTag(TAG_MAP) ?: MapFragment()
        replaceFragment(mapFragment, TAG_MAP, true)
    }

    private fun replaceFragment(fragment: Fragment, tag: String, fromInfo: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.takeIf { fromInfo }?.setCustomAnimations(
            R.animator.nav_show_next,
            R.animator.nav_hide_prev,
            R.animator.nav_show_prev,
            R.animator.nav_hide_next
        )
        transaction.replace(R.id.fl_container, fragment, tag)
        transaction.takeIf { fromInfo }?.addToBackStack(null)
        transaction.commit()
    }
}