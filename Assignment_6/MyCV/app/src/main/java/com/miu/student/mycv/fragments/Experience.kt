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
import com.miu.student.mycv.databinding.FragmentExperienceBinding


class Experience : Fragment() {
    private lateinit var experienceBinding: FragmentExperienceBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var experiences = ArrayList<ListItem>()
        experiences.add(ListItem("Senior Software Developer", "Kforce Inc · Full-time", R.drawable.kforce, "Feb 2022 - Present", "Tampa, Florida, United States-Remote", ""))
        experiences.add(ListItem("Technical Team Leader", "Vinnell Arabia", R.drawable.vinnellarabia, "Apr 2017 - Apr 2021 · 4 yrs 1 mo", "Riyadh-Saudi Arabia", "Led technical team through all phases of software development life cycle while consulting for Ministry of National Guard on application development.\n" +
                "• Developed correspondence tracking system with e-signature feature, Dynamic DMS system, Student Graduation Distribution System, Retirement Application Workflow System, E-Gate Pass Workflow System, and E-Pass System for SANG employee prior to COVID lockdown.\n" +
                "• Established migration tools to map and migrate data from old to the new application.\n" +
                "• Streamlined integration of internal and external applications.\n" +
                "• Implemented MS SQL Server performance tuning. \n" +
                "• Reduced paper usage 95% within the organization and 20% with communications outside the organization.\n" +
                "• Improved development time by establishing Azure DevOps CICD on client applications.\n" +
                "• Ensured successful completion of projects by resolving issues and leveraging developers’ technical skills."))
        experiences.add(ListItem("Technical Team Leader", "Universal for Trading & Information Technology Co.", R.drawable.utit, "Jul 2014 - Apr 2017 · 2 yrs 10 mos", "Riyadh-Saudi Arabia", "Universal for Trading & Information Technology Co. logo\n" +
                "Universal for Trading & Information Technology Co.Universal for Trading & Information Technology Co.\n" +
                "5 yrs 10 mos5 yrs 10 mos\n" +
                "Technical Team LeaderTechnical Team Leader\n" +
                "Jul 2014 - Apr 2017 · 2 yrs 10 mosJul 2014 - Apr 2017 · 2 yrs 10 mos\n" +
                "Designed and implemented high performance applications.\n" +
                "• Led development of Student Information System with financial and payroll modules, Correspondence Tracking and Archiving System, and Saudi Festival Gate Pass Card Printing web application.\n" +
                "• Resolved system failures to maximize performance and functionality.\n" +
                "• Established production environment servers’ structure." ))
        experiences.add(ListItem("Web Developer using C#", "GW-Group Of Work For IT Solutions", R.drawable.gw, "Jul 2008 - Jun 2011 · 3 yrs", "Riyadh-Saudi Arabia", "• Designed active server pages using ASP.NET and ADO.NET to implement CRUD operation on SQL Server database.\n" +
                "• Contributed to the development of the government procurement system." ))
        experiences.add(ListItem("Technical Support", "Horizon for Computer & Communication", R.drawable.company, "Jul 2004 - Jul 2005 · 1 yr 1 mo", "Riyadh-Saudi Arabia", "Mission:\n" +
                "PC's Support engineering for installation, troubleshooting, maintenance, with a special focus on the following:\n" +
                "Low Range PC.\n" +
                "\n" +
                "OS Troubleshooting\n" +
                "\n" +
                "Business Task:\n" +
                "Customer side visit & fast response for the client complains." ))

var view =inflater.inflate(R.layout.fragment_experience, container, false)  ;

        var adapter = ListItemAdapter(experiences)
        experienceBinding = FragmentExperienceBinding.bind(view)
        experienceBinding.rvItems.addItemDecoration(
            DividerItemDecoration(
                experienceBinding.rvItems.context,
                DividerItemDecoration.VERTICAL
            )
        )

        experienceBinding.rvItems.layoutManager = LinearLayoutManager(experienceBinding.root.context)
        experienceBinding.rvItems.adapter = adapter
        return view;
    }
}