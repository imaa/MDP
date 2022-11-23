package com.miu.student.mycv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.student.mycv.R
import com.miu.student.mycv.adapters.ListItemAdapter
import com.miu.student.mycv.data.ListItem
import com.miu.student.mycv.databinding.FragmentEducationBinding

class Education : Fragment() {
    private lateinit var educationBinding: FragmentEducationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_education, container, false)

        var educations = ArrayList<ListItem>()
        educations.add(ListItem("Master of Science in Computer Science", "Maharishi International University", R.drawable.miu, "2021 - 2023", "Fairfield IA US", ""))
        educations.add(ListItem("Bachelor of Computer Information Systems", "Al-Hussein Bin Talal University", R.drawable.ahu, "2003 - 2007", "Ma'an Jordan", ""))
          var adapter = ListItemAdapter(educations)
        educationBinding = FragmentEducationBinding.bind(view)
        educationBinding.rvItems.addItemDecoration(
            DividerItemDecoration(
                educationBinding.rvItems.context,
                DividerItemDecoration.VERTICAL
            )
        )

        educationBinding.rvItems.layoutManager = LinearLayoutManager(educationBinding.root.context)
        educationBinding.rvItems.adapter = adapter
        return view;
    }
}