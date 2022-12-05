package com.miu.student.mycv.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.student.mycv.PdfViewer
import com.miu.student.mycv.R
import com.miu.student.mycv.adapters.ContactItemAdapter
import com.miu.student.mycv.data.ContactItem
import com.miu.student.mycv.data.ContactType
import com.miu.student.mycv.databinding.FragmentContactBinding

class Contact : Fragment() {

    lateinit var binding: FragmentContactBinding
    val myEmail = "ib.abulubad@gmail.com"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_contact, container, false)
        binding = FragmentContactBinding.bind(view)
        var contacts = ArrayList<ContactItem>()
        contacts.add(ContactItem(ContactType.EMAIL, myEmail, R.drawable.ic_email))
        contacts.add(ContactItem(ContactType.PHONE, "+1 319-677-0270", R.drawable.ic_phone))
        contacts.add(
            ContactItem(
                ContactType.LINKEDIN,
                "https://www.linkedin.com/in/ibrahim-abulubad/",
                R.drawable.ic_linkedin
            )
        )
        contacts.add(
            ContactItem(
                ContactType.GITHUB,
                "https://github.com/imaa",
                R.drawable.ic_github
            )
        )
        contacts.add(ContactItem(ContactType.RESUME, "View My Resume", R.drawable.ic_pdf))
        var adapter = ContactItemAdapter(contacts)
        adapter.onItemClick = {
            when (it.type) {
                ContactType.EMAIL -> {
                    // open email intern app
                    val emailIntent = Intent(
                        Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", myEmail, null
                        )
                    )
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Interested in your CV")
                    startActivity(Intent.createChooser(emailIntent, "Send email..."))
                }
                ContactType.PHONE -> {
                    // open phone dialer
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:${it.value}")
                    startActivity(intent)
                }
                ContactType.LINKEDIN -> {
                    // open linkedin profile
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(it.value)
                    startActivity(intent)
                }
                ContactType.GITHUB -> {
                    // open github profile
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(it.value)
                    startActivity(intent)
                }
                ContactType.RESUME ->{
                    // start pdf viewer activity
                    val intent = Intent(context, PdfViewer::class.java)
                    startActivity(intent)
                }
            }
        }
        binding.rvContacts.addItemDecoration(
            DividerItemDecoration(
                binding.rvContacts.context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.rvContacts.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvContacts.adapter = adapter


        return view
    }
}