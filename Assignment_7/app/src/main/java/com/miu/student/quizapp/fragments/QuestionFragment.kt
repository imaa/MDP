package com.miu.student.quizapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.miu.student.quizapp.R
import com.miu.student.quizapp.data.domain.Question
import com.miu.student.quizapp.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private lateinit var binding: FragmentQuestionBinding
    private val nargs: QuestionFragmentArgs by navArgs()
    private  var timeRemainingMS: Long=0
    private lateinit var questions: Array<Question>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_question, container, false)
        questions = nargs.questions
        timeRemainingMS = nargs.timeRemaining
        binding = FragmentQuestionBinding.bind(view)
        binding.apply {
            questionNumber.text = "Question ${nargs.questionIndex + 1} of ${questions.size}"
            nextButton.setOnClickListener {
                if (nargs.questionIndex == questions.size - 1) {
                    val directions =
                        QuestionFragmentDirections.actionQuestionFragmentToResultFragment(questions)
                    findNavController().navigate(directions)
                } else {
                    val directions =
                        QuestionFragmentDirections.actionQuestionFragmentSelf(
                            questions,
                            nargs.questionIndex + 1,
                            timeRemainingMS
                        )
                    findNavController().navigate(directions)
                }
            }
            if (nargs.questionIndex == questions.size - 1)
                nextButton.text = "Finish"
            else
                nextButton.text = "Next"
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var question = questions[nargs.questionIndex]

        binding.question.text = question.text
        for (answer in question.answers!!) {
            val radioButton = RadioButton(context)
            radioButton.text = answer.text
            binding.answers.addView(radioButton)
        }
    }

    override fun onStart() {
        super.onStart()

        val countDownInterval = 1000L // 1 second in milliseconds
        object : CountDownTimer(nargs.timeRemaining, countDownInterval) {

            override fun onTick(millisUntilFinished: Long) {
                val secondsUntilFinished = millisUntilFinished / 1000
                val minutes = secondsUntilFinished / 60
                val seconds = secondsUntilFinished % 60
                val timeRemaining = "$minutes:$seconds"
                binding.timer.text = timeRemaining
                timeRemainingMS = millisUntilFinished
            }

            override fun onFinish() {
            }
        }.start()
    }
}