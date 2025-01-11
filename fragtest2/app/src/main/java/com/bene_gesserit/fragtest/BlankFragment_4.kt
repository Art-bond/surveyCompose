package com.bene_gesserit.fragtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank4Binding

private const val ARG_PARAM1 = "name"

class BlankFragment_4 : Fragment() {

    private var name: String? = null

    private val dataModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentBlank4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank4Binding.inflate(inflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView.text = "$binding.textView.text \n name: $name"

        binding.buttonBlankFragment5.setOnClickListener {
            dataModel.report.value!!.isMale = false

            Log.d("mylog", "BlankFragment_4" + dataModel.report.value!!.isMale.toString())

            dataModel.message.value = STATE.BLANK_FRAGMENT_5
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String) =
            BlankFragment_4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                }
            }
    }
}