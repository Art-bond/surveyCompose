package com.bene_gesserit.fragtest.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bene_gesserit.fragtest.BlankFragment_1
import com.bene_gesserit.fragtest.BlankFragment_2
import com.bene_gesserit.fragtest.BlankFragment_3
import com.bene_gesserit.fragtest.BlankFragment_4
import com.bene_gesserit.fragtest.BlankFragment_5
import com.bene_gesserit.fragtest.BlankFragment_6
import com.bene_gesserit.fragtest.BlankFragment_7
import com.bene_gesserit.fragtest.DataViewModel
import com.bene_gesserit.fragtest.R
import com.bene_gesserit.fragtest.STATE
import com.bene_gesserit.fragtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dataModel: DataViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurveyScreen(dataModel)
        }
    }

    private fun getData() {

        dataModel.report.observe(this) {
            Log.d("mylog", dataModel.report.value!!.id.toString())
            Log.d("mylog", dataModel.report.value!!.name)
            Log.d("mylog", dataModel.report.value!!.isMale.toString())
        }
    }

    private fun manageFragments() {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, BlankFragment_1.newInstance())
            .commit()

        dataModel.message.observe(this) {

            when (it) {
                STATE.BLANK_FRAGMENT_1 -> {
                   // openFragment(R.id.frame, BlankFragment_1.newInstance())
                }
                STATE.BLANK_FRAGMENT_2 -> {
                    openFragment(R.id.frame, BlankFragment_2.newInstance())
                }
                STATE.BLANK_FRAGMENT_3 -> {
                    openFragment(
                        R.id.frame,
                        BlankFragment_3.newInstance(dataModel.report.value!!.id)
                    )
                }
                STATE.BLANK_FRAGMENT_4 -> {
                    openFragment(
                        R.id.frame,
                        BlankFragment_4.newInstance(dataModel.report.value!!.name)
                    )
                }
                STATE.BLANK_FRAGMENT_5 -> {
                    openFragment(
                        R.id.frame,
                        BlankFragment_5.newInstance(dataModel.report.value!!.isMale)
                    )
                }
                STATE.BLANK_FRAGMENT_6 -> {
                    openFragment(R.id.frame, BlankFragment_6.newInstance())
                }
                STATE.BLANK_FRAGMENT_7 -> {
                    openFragment(R.id.frame, BlankFragment_7.newInstance())
                }
            }
        }
    }

    private fun openFragment(idHolder: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment)
            .addToBackStack(null)
            .commit()
    }

}