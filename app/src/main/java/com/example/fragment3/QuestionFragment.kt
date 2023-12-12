package com.example.fragment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class QuestionFragment: Fragment() {

    private lateinit var txtQuestions : TextView
    private lateinit var txtAnswer : TextView
    private lateinit var btnOptions : TextView


    var selectedOptions = ""
        set(value) {
            field = value
            txtAnswer.text = value
        }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.question_fragment,null)

        initViews(view)
        initListener()
        return view
    }
    private fun initViews(view: View){
        txtQuestions = view.findViewById(R.id.txtQuestions)
        txtAnswer = view.findViewById(R.id.txtAnswer)
        btnOptions = view.findViewById(R.id.btnoptions)
    }
    private fun initListener(){
        btnOptions.setOnClickListener{
            val optionsFragment = OptionsFragment()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer,optionsFragment,null)
                .commit()
        }
    }
}