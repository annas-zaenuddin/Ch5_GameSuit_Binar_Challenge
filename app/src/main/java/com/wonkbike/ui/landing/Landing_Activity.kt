package com.wonkbike.ui.landing


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wonkbike.ch5_gamesuit.R
import com.wonkbike.ui.menu.MenuActivity
import com.wonkbike.utils.ViewPagerAdapter

class LandingActivity : AppCompatActivity() {

    private var name: String = ""
    private lateinit var vpLanding: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val viewPagerAdapter = ViewPagerAdapter(this) {
            name = it.toString()
        }

        vpLanding = findViewById<ViewPager2>(R.id.vpLanding)
        vpLanding.adapter = viewPagerAdapter
        findViewById<DotsIndicator>(R.id.diLanding).setViewPager2(vpLanding)

        findViewById<ImageView>(R.id.ivNext).setOnClickListener {
            when {
                vpLanding.currentItem < 2 -> {
                    vpLanding.currentItem = vpLanding.currentItem.plus(1)
                }
                name != "" -> {
                    Intent(this , MenuActivity::class.java)
                        .apply {
                            putExtra("Name" , name)
                            startActivity(this)
                            finish()
                        }
                }
                else -> {
                    Toast.makeText(
                        this ,
                        "Please Create Your Name" , Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onBackPressed() =
        if (vpLanding.currentItem > 0) vpLanding.currentItem =
            vpLanding.currentItem.minus(1) else finish()
}