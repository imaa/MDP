package com.miu.student.quizapp.fragments

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miu.student.quizapp.QuizApp
import com.miu.student.quizapp.R
import com.miu.student.quizapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        binding.apply {
            btnStart.setOnClickListener {
                AsyncTask.execute {
                    val questions = QuizApp.database.questionDao().getAll()

                    activity?.runOnUiThread {
                        //use navigation component to navigate to the next fragment
                        val directions =
                            HomeFragmentDirections.actionHomeFragmentToQuestionFragment(
                                questions.shuffled().toTypedArray(),
                                0,
                                questions.size * 60 * 1000L
                            )
                        findNavController().navigate(directions)
                    }
                }
            }
        }
        return binding.root
    }

}