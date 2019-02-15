/*
 * @copyright ©2019 Onoff Insurance All rights reserved. Trade Secret, Confidential and Proprietary.
 *               Any dissemination outside of Onoff Insurance is strictly prohibited.
 */

package insure.onoff.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import insure.onoff.R
import insure.onoff.utilities.ANIMATION_DURATION

/**
 * SplashActivity
 *
 * This class is use to view splash screen and do background check
 *
 * @author    Charles S  <charlessetiadi@onoff.insure>
 */
class SplashActivity : AppCompatActivity() {
    // Initialize Handler to run runnable at some time
    private var mDelayHandler: Handler? = null

    // Initialize Passing to MainActivity
    internal val mRunnable: Runnable = Runnable {
        // Delay process finish by handler
        if (!isFinishing) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /**
     * Create view activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize the Handler
        mDelayHandler = Handler()
        // Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, ANIMATION_DURATION)
    }

    /**
     * Remove Activity State
     */
    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}
