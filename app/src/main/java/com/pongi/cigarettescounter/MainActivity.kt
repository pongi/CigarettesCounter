package com.pongi.cigarettescounter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fab_layout.*


class MainActivity : AppCompatActivity() {

    var fabOpenState = false

    //Animations
    var showFab1: Animation? = null
    var hideFab1: Animation? = null
    var showFab2: Animation? = null
    var hideFab2: Animation? = null
    var showFab3: Animation? = null
    var hideFab3: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Animations
        showFab1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
        hideFab1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
        showFab2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_show);
        hideFab2 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab2_hide);
        showFab3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_show);
        hideFab3 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab3_hide);

        // Load an ad into the AdMob banner view.
        val adRequest = AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template")
                .build()
        adView.loadAd(adRequest)

        // FABの設定
        fab.setOnClickListener {
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            if (fabOpenState) hideFAB() else expandFAB()

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

    fun expandFAB() {
        val layoutParams1 = fab1.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams1.rightMargin += (fab1.width * 1.7).toInt()
        layoutParams1.bottomMargin += (fab1.height * 0.25).toInt()
        fab1.setLayoutParams(layoutParams1)
        fab1.startAnimation(showFab1)
        fab1.setClickable(true)

        //Floating Action Button 2
        val layoutParams2 = fab2.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin += (fab2.width * 1.5).toInt()
        layoutParams2.bottomMargin += (fab2.height * 1.5).toInt()
        fab2.layoutParams = layoutParams2
        fab2.startAnimation(showFab2)
        fab2.isClickable = true

        //Floating Action Button 3
        val layoutParams3 = fab3.layoutParams as FrameLayout.LayoutParams
        layoutParams3.rightMargin += (fab3.width * 0.25).toInt()
        layoutParams3.bottomMargin += (fab3.height * 1.7).toInt()
        fab3.layoutParams = layoutParams3
        fab3.startAnimation(showFab3)
        fab3.isClickable = true

        fabOpenState = true
    }

    fun hideFAB() {
        val layoutParams1 = fab1.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams1.rightMargin -= (fab1.width * 1.7).toInt()
        layoutParams1.bottomMargin -= (fab1.height * 0.25).toInt()
        fab1.setLayoutParams(layoutParams1)
        fab1.startAnimation(hideFab1)
        fab1.setClickable(false)

        //Floating Action Button 2
        val layoutParams2 = fab2.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin -= (fab2.width * 1.5).toInt()
        layoutParams2.bottomMargin -= (fab2.height * 1.5).toInt()
        fab2.layoutParams = layoutParams2
        fab2.startAnimation(hideFab2)
        fab2.isClickable = false

        //Floating Action Button 3
        val layoutParams3 = fab3.layoutParams as FrameLayout.LayoutParams
        layoutParams3.rightMargin -= (fab3.width * 0.25).toInt()
        layoutParams3.bottomMargin -= (fab3.height * 1.7).toInt()
        fab3.layoutParams = layoutParams3
        fab3.startAnimation(hideFab3)
        fab3.isClickable = false

        fabOpenState = false
    }


}
