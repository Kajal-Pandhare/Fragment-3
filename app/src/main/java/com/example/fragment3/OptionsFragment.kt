package com.example.fragment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class OptionsFragment : Fragment() {

    private lateinit var txtYes : TextView
    private lateinit var txtNo : TextView
    private lateinit var txtMaybe : TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.options_fragment,null)

        initViews(view)
        initListener()

        return view
    }
    private fun initViews(view: View){
        txtYes = view.findViewById(R.id.txtYes)
        txtNo = view.findViewById(R.id.txtNo)
        txtMaybe = view.findViewById(R.id.txtMayBe)
    }

    private fun initListener(){
        txtYes.setOnClickListener{
            (requireActivity() as MainActivity).setSelectedOption("yes")
            removeFragment()
        }

        txtNo.setOnClickListener{
            (requireActivity() as MainActivity).setSelectedOption("No")
            removeFragment()
        }
        txtMaybe.setOnClickListener{
            (requireActivity() as MainActivity).setSelectedOption("May be")
            removeFragment()
        }
    }
    private fun removeFragment(){
        parentFragmentManager.beginTransaction()
            .remove(this)
            .commit()
    }
}