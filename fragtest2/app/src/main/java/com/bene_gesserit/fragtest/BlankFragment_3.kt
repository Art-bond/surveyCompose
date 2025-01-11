package com.bene_gesserit.fragtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank3Binding

private const val ARG_PARAM1 = "id"

class BlankFragment_3 : Fragment() {

    private var id: Int? = null

    private val dataModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentBlank3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank3Binding.inflate(inflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView.text = "$binding.textView.text \n id: $id"

        binding.buttonBlankFragment4.setOnClickListener {
            dataModel.report.value!!.name = "Lili"

            Log.d("mylog", "BlankFragment_3" + dataModel.report.value!!.name)

            dataModel.message.value = STATE.BLANK_FRAGMENT_4
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: Int) =
            BlankFragment_3().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, id)
                }
            }
    }
}