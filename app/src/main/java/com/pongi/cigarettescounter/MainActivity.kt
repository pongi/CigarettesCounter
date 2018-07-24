package com.pongi.cigarettescounter

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.gms.ads.AdRequest

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var fabOpenState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Load an ad into the AdMob banner view.
        val adRequest = AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template")
                .build()
        adView.loadAd(adRequest)

        // FABの設定
        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            if(fabOpenState) fabClose() else fabOpen()

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
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun fabOpen(){
        val iconWhile = dpToPx(66, this.getApplicationContext())

        var anim = ObjectAnimator.ofFloat(fab_chart, "translationY", -iconWhile)
        anim.duration = 200
        anim.start()

        anim = ObjectAnimator.ofFloat(fab_setting, "translationY", -iconWhile * 2)
        anim.duration = 200
        anim.start()

        fabOpenState = true

    }

    fun fabClose(){
        val iconWhile = dpToPx(66, this.getApplicationContext())

        var anim = ObjectAnimator.ofFloat(fab_chart, "translationY", 0f)
        anim.duration = 200
        anim.start()

        anim = ObjectAnimator.ofFloat(fab_setting, "translationY",  0f)
        anim.duration = 200
        anim.start()

        fabOpenState = false
    }


}
