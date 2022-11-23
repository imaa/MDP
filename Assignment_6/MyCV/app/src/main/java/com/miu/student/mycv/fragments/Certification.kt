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
import com.miu.student.mycv.databinding.FragmentCertificationBinding
import com.miu.student.mycv.databinding.FragmentEducationBinding

class Certification : Fragment() {
private lateinit var certificationBinding: FragmentCertificationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_certification, container, false)
        certificationBinding = FragmentCertificationBinding.bind(view)
        var certificates = ArrayList<ListItem>()
        certificates.add(ListItem("MCPS: Microsoft Certified Professional", "Microsoft", R.drawable.microsoft, "Issued Feb 2016 ", "", ""))
        certificates.add(ListItem("MS: Programming in HTML5 with JavaScript and CSS3", "Microsoft", R.drawable.microsoft, "Issued Feb 2016", "", ""))
        certificates.add(ListItem("MTA: Software Development Fundamentals", "Microsoft", R.drawable.microsoft, "Issued Jan 2016 ", "", ""))

        var adapter = ListItemAdapter(certificates)
        certificationBinding = FragmentCertificationBinding.bind(view)
        certificationBinding.rvItems.addItemDecoration(
            DividerItemDecoration(
                certificationBinding.rvItems.context,
                DividerItemDecoration.VERTICAL
            )
        )

        certificationBinding.rvItems.layoutManager = LinearLayoutManager(certificationBinding.root.context)
        certificationBinding.rvItems.adapter = adapter

        return view

    }
}