package com.mashup.base.sample

import android.os.Bundle
import com.mashup.base.R
import com.mashup.base.baseview.BaseActivity
import com.mashup.base.databinding.ActivitySampleBinding
import com.mashup.base.sample.base.RecyclerViewFragment
import com.mashup.base.sample.live.LiveRecyclerViewFragment
import com.mashup.base.sample.simple.SimpleRecyclerViewFragment

class SampleActivity : BaseActivity<ActivitySampleBinding>(R.layout.activity_sample) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.lyt_sample_container, SampleFragment.newInstance())
            .commit()
    }

    fun goToRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, RecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun goToSimpleRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, SimpleRecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun goToLiveRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, LiveRecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
