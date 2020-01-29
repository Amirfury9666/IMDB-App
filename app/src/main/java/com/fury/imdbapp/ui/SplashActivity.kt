package com.fury.imdbapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.fury.imdbapp.R
import com.fury.imdbapp.base.core.BaseActivity
import com.fury.imdbapp.databinding.ActivitySplashBinding

private const val SPLASH_TIME = 1500L
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_splash

    override fun getToolbar(binding: ActivitySplashBinding): Toolbar? {return null}

    override fun onActivityReady(instanceState: Bundle?, binding: ActivitySplashBinding) {
        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }

}
