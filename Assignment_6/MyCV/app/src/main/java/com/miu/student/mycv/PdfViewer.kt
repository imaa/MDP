package com.miu.student.mycv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.student.mycv.databinding.ActivityPdfViewerBinding

class PdfViewer : AppCompatActivity() {
    lateinit var binding: ActivityPdfViewerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,
            android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityPdfViewerBinding.inflate(layoutInflater)
        binding.pdfView.fromAsset("resume.pdf").load()


        setContentView(binding.root)
    }
}