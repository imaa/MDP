package com.miu.student.quizapp.fragments

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.miu.student.quizapp.R
import com.miu.student.quizapp.data.domain.Question
import com.miu.student.quizapp.databinding.FragmentAnalysisBinding

class AnalysisFragment : Fragment() {

    private lateinit var binding: FragmentAnalysisBinding
    private val nargs: AnalysisFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_analysis, container, false)
        binding = FragmentAnalysisBinding.bind(view)
        binding.apply {

            analysisLayout.removeAllViews()
            showResult(analysisLayout, nargs.questions)
        }
        return binding.root
    }

    private fun showResult(analysisLayout: LinearLayout, questions: Array<Question>) {
        for (question in questions) {
            val questionTextView = TextView(context)
            questionTextView.text =
                (questions.indexOf(question) + 1).toString() + " : " + question.text
            questionTextView.textSize = 18f
            questionTextView.setTypeface(null, Typeface.BOLD)
            analysisLayout.addView(questionTextView)

            val answersLayout = LinearLayout(context)
            answersLayout.orientation = LinearLayout.VERTICAL
            analysisLayout.addView(answersLayout)
            var showCorrectAnswer = false
            for (answer in question.answers!!) {
                val answerTextView = TextView(context)
                answerTextView.text = (question.answers?.indexOf(answer)!! + 1).toString() + " - " + answer.text
                answerTextView.textSize = 16f

                if (answer == question.selectedAnswer) {
                    if (answer.isCorrect) {
                        showCorrectAnswer=false
                        answerTextView.setTextColor(resources.getColor(R.color.correctAnswer))
                    } else {
                        answerTextView.setTextColor(resources.getColor(R.color.incorrectAnswer))
                        showCorrectAnswer = true
                    }
                }

                answersLayout.addView(answerTextView)
            }
            if(showCorrectAnswer){
                for (a in question.answers!!) {
                    if (a.isCorrect) {
                        val correctAnswerTextView = TextView(context)
                        correctAnswerTextView.text = "Correct answer: ${ question.answers?.indexOf(a)!! + 1} - ${a.text}"
                        correctAnswerTextView.textSize = 16f
                        correctAnswerTextView.setTextColor(resources.getColor(R.color.correctAnswer))
                        correctAnswerTextView.setTypeface(null, Typeface.ITALIC)
                        answersLayout.addView(correctAnswerTextView)
                        break
                    }
                }
            }
            // Add separator line
            if (question != questions.last()) {
                val separatorLine = View(context)
                val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
                layoutParams.setMargins(0, 16, 0, 16)
                separatorLine.layoutParams = layoutParams
                separatorLine.setBackgroundColor(resources.getColor(R.color.black))
                analysisLayout.addView(separatorLine)
            }
        }
        //add go home button
        val goHomeButton = Button(context)
        goHomeButton.text = "Go Home"
        goHomeButton.textSize = 18f
        goHomeButton.setTextColor(resources.getColor(R.color.white))
        goHomeButton.setPadding(16, 8, 16, 8)
        goHomeButton.setOnClickListener {
            val directions =
                AnalysisFragmentDirections.actionAnalysisFragmentToHomeFragment()
            findNavController().navigate(directions)
        }
        analysisLayout.addView(goHomeButton)
    }
}