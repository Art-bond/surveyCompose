package com.bene_gesserit.fragtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank4Binding

class BlankFragment_4 : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank4Binding.inflate(inflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonBlankFragment5.setOnClickListener {
            dataModel.message.value = STATE.BLANK_FRAGMENT_5
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment_4()
    }
}