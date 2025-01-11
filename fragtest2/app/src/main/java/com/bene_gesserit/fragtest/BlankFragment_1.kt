package com.bene_gesserit.fragtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank1Binding

class BlankFragment_1 : Fragment() {

    private val dataModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentBlank1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank1Binding.inflate(inflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonBlankFragment2.setOnClickListener {
            dataModel.message.value = STATE.BLANK_FRAGMENT_2
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment_1()
    }
}