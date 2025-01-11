package com.bene_gesserit.fragtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bene_gesserit.fragtest.databinding.FragmentBlank5Binding

private const val ARG_PARAM1 = "isMale"

class BlankFragment_5 : Fragment() {

    private var isMale: Boolean? = null

    private val dataModel: DataViewModel by activityViewModels()
    lateinit var binding: FragmentBlank5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isMale = it.getBoolean(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank5Binding.inflate(inflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textView.text = "$binding.textView.text \n isMale: $isMale"

        binding.buttonBlankFragment6.setOnClickListener {
            dataModel.message.value = STATE.BLANK_FRAGMENT_6
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(isMale: Boolean) =
            BlankFragment_4().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM1, isMale)
                }
            }
    }
}