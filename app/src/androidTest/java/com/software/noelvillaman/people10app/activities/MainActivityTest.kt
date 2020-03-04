package com.software.noelvillaman.people10app.activities

import androidx.recyclerview.widget.RecyclerView
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.software.noelvillaman.people10app.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertNotNull

class MainActivityTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    var mActivity : MainActivity? = null

    val monitor =
        getInstrumentation().addMonitor(StoreInformation::class.java.getName(), null, false)


    @Before
    fun setUp() {
        mActivity = mActivityTestRule.activity
    }

    @Test
    fun checkActivityStartsWithNoProblem() {
        val mRecycleView = mActivity!!.findViewById<RecyclerView>(R.id.store_list)
        assertNotNull(mRecycleView)
    }

    @After
    fun tearDown() {
        mActivity = null
    }


}