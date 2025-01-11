package com.bene_gesserit.fragtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank2Binding

class BlankFragment_2 : Fragment() {

    private val dataModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonBlankFragment3.setOnClickListener {
            dataModel.report.value!!.id = 13

            Log.d("mylog", "BlankFragment_2" + dataModel.report.value!!.id.toString())

            dataModel.message.value = STATE.BLANK_FRAGMENT_3
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment_2()
    }
}