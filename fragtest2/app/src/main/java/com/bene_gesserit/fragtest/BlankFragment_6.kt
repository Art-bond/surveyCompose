package com.bene_gesserit.fragtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank6Binding

class BlankFragment_6 : Fragment() {

    private val dataModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentBlank6Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank6Binding.inflate(inflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonBlankFragment7.setOnClickListener {
            dataModel.message.value = STATE.BLANK_FRAGMENT_7
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment_6()
    }
}